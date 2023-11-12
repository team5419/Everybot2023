// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;


public class Arm extends SubsystemBase {

  // TODO: ADD AND SET CAN ID(s)
  private final int CAN_ID = 5;

  // TODO: DECLARE MOTOR (CANSparkMax object)
  private CANSparkMax arm; 
  private RelativeEncoder armEncoder;
  private SparkMaxPIDController armController;

  // set motor current limits
  private final int ARM_CURRENT_LIMIT = 20;
  private double armTarget;
  public final double armLow = 1;
  public final double armHigh = -37;
  public final double armMedium = -20;
  public int lastPos = 0;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;

  public Arm() {
    // TODO: Initialize motor controller
    arm = new CANSparkMax(CAN_ID, MotorType.kBrushless);

    // TODO: set current limit
    arm.setSmartCurrentLimit(ARM_CURRENT_LIMIT);

    // TODO: set motor in brake mode so that the motor holds position even when not given a command
    arm.setIdleMode(IdleMode.kBrake);

    arm.setInverted(true);

    armEncoder = arm.getEncoder();
    arm.setSmartCurrentLimit(ARM_CURRENT_LIMIT);
    armController = arm.getPIDController();
    armTarget = 1;

    kP = 0.05;
    kI = 0;
    kD = 0;
    kIz = 0;
    kFF = 0;
    kMaxOutput = 0.3;
    kMinOutput = -0.3;

    armController.setP(kP);
    armController.setI(kI);
    armController.setD(kD);
    armController.setIZone(kIz);
    armController.setFF(kFF);
    armController.setOutputRange(kMinOutput, kMaxOutput);



    /* TODO; ARM POSITION CONTROL TASK */
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
  /*public void TargetHigh(){
    armTarget = armHigh;
  }

  public void TargetMedium(){
    armTarget = armMedium;
  }

  public void TargetLow(){
    armTarget = armLow;
  }*/

  public void setArmPower(double power)
  {
    arm.set(power);
  }
  public void SetToPosition(double target){
    armController.setReference(target, CANSparkMax.ControlType.kPosition);
    armTarget = target;
  }
  public void stop(){
    arm.set(0);
  }
  public boolean isAtPosition(double tolerance){
    //return armEncoder.getPosition() > armTarget + tolerance && armEncoder.getPosition() < armTarget  tolerance;
    return Math.abs(armTarget - armEncoder.getPosition())<tolerance;
  }
  public void zero(){//zero the arm encoder
    armEncoder.setPosition(0);
  }
  // TODO: ADD MOTOR ACCESSORS FOR SETTING TARGET POSITION
  // Other classes/commands do not have access to the private motor object so you have to make it
  // accessible
 /*  public void setArmTarget() {}

  public void getArmPosition() {}
  // TODO: ADD MOTOR ACCESSORS FOR ZEROING MOTOR POWER AND MOTOR ENCODER
  public void stopArmInput() {}

  public void zeroArmEncoder() {}
  */
  // TODO: DETECT IF ARM HAS HIT A HARDSTOP (check motor current)
  public boolean hasHitHardstop() {
    return false; // TODO: placeholder -- replace
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("encoder position", armEncoder.getPosition());
  }
}
