// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends SubsystemBase {

  // ADD AND SET CAN ID(s)
  private final int ArmID = 5;

  // DECLARE MOTOR (CANSparkMax object)
  private final CANSparkMax m_Arm;
  private final RelativeEncoder m_encoder;

  // set motor current limits
  private final int ARM_CURRENT_LIMIT = 20;

  // TODO: DEFINE ARM POSITIONS FOR LOW, MEDIUM, HIGH, AND PLATFORM INTAKE

  // TODO: DECLARE SHUFFLEBOARD ENTRIES FOR ARM MOTOR TICKS AND ARM PID
  // public static final

  public Arm() {
    // Initialize motor controller
    m_Arm = new CANSparkMax(ArmID, MotorType.kBrushless);
    // set current limit
    m_Arm.setSmartCurrentLimit(ARM_CURRENT_LIMIT);
    // set motor to brake mode
    m_Arm.setIdleMode(IdleMode.kBrake);
    m_encoder = m_Arm.getEncoder();
    // SmartDashboard.putNumber("Arm Motor Ticks", m_Arm.getEncoder());

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
  public void setArmTarget() {}

  public void getArmPosition() {}
  // TODO: ADD MOTOR ACCESSORS FOR ZEROING MOTOR POWER AND MOTOR ENCODER
  public void stopArmInput() {}

  public void zeroArmEncoder() {}

  // DETECT IF ARM HAS HIT A HARDSTOP (check motor current)
  public boolean hasHitHardstop() {
    if (m_Arm.getOutputCurrent() >= 10 /* TODO: placeholder -- replace */) {
      return true;
    }
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // UPDATE THE SHUFFLEBOARD ENTRIES
    ShuffleboardTab arm = Shuffleboard.getTab("Arm");
    arm.addNumber("Encoder angle", () -> m_encoder.getPosition());
  }
}
