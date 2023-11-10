// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {

  // defines can ID
  private final int armID = 0; //change this later
  //defines motor
  private final CANSparkMax ArmMotor;
  //defines encoder
  private RelativeEncoder m_encoder;
  // set motor current limits
  private final int ARM_CURRENT_LIMIT = 20;
  // set arm targets for low, medium, high, and platform intake.
  private int armTarget;

  private final int armLow;
  private final int armHigh;
  private final int armMedium;



  // TODO: DECLARE SHUFFLEBOARD ENTRIES FOR ARM MOTOR TICKS AND ARM PID
  // public static final

  public Arm() {
    ArmMotor = new CANSparkMax(armID,MotorType.kBrushless);
    ArmMotor.setSmartCurrentLimit(ARM_CURRENT_LIMIT);
    armTarget = 1;
    armLow = 1;
    armHigh = 1;
    armMedium = 1;

    // TODO: set motor in brake mode so that the motor holds position even when not given a command
    // m_arm.setIdleMode(IdleMode.kBrake);

    // TODO: SET MOTOR CONTROLLER PID VALUES
    // example syntax
    // // set PID coefficients
    // m_pidController.setP(kP);
    // m_pidController.setI(kI);
    // m_pidController.setD(kD);
    // m_pidController.setIZone(kIz);
    // m_pidController.setFF(kFF);
    // m_pidController.setOutputRange(kMinOutput, kMaxOutput);

    // // display PID coefficients on SmartDashboard
    // SmartDashboard.putNumber("P Gain", kP);
    // SmartDashboard.putNumber("I Gain", kI);
    // SmartDashboard.putNumber("D Gain", kD);
    // SmartDashboard.putNumber("I Zone", kIz);
    // SmartDashboard.putNumber("Feed Forward", kFF);
    // SmartDashboard.putNumber("Max Output", kMaxOutput);
    // SmartDashboard.putNumber("Min Output", kMinOutput);
    // SmartDashboard.putNumber("Set Rotations", 0);

    // TODO: INITIALIZE SHUFFLEBOARD ENTRIES
  }

  // TODO: ADD MOTOR ACCESSORS FOR SETTING TARGET POSITION
  // Other classes/commands do not have access to the private motor object so you have to make it
  // accessible
  public void TargetHigh(){
    armTarget = armHigh;
  }

  public void TargetMedium(){
    armTarget = armMedium;
  }

  public void TargetLow(){
    armTarget = armLow;
  }
  public void SetToPosition(){
    if (m_encoder.getPosition() > armTarget){
      ArmMotor.set(0.5);
    }
    if (m_encoder.getPosition()<armTarget){
      ArmMotor.set(-0.5);
    }
    if (m_encoder.getPosition() == armTarget){
      ArmMotor.set(0);
    }
  }
  public void stop(){
    ArmMotor.set(0);
  }
  public boolean isAtPosition(){
    return m_encoder.getPosition() == armTarget;
  }
  public void manual(double amount){//for manual movement
    ArmMotor.set(amount);
  }
  /*public void setArmTarget(int target) {
    //armTarget = target;
  }

  public void getArmPosition() {}
  // TODO: ADD MOTOR ACCESSORS FOR ZEROING MOTOR POWER AND MOTOR ENCODER
  public void stopArmInput() {}

  public void zeroArmEncoder() {
    //armEncoder.setPosition(0.0);
  }

  // TODO: DETECT IF ARM HAS HIT A HARDSTOP (check motor current)
  public boolean hasHitHardstop() {
    return false; // TODO: placeholder -- replace
  }
  */
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // TODO: UPDATE THE SHUFFLEBOARD ENTRIES
  }
}
