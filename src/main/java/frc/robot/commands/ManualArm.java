// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

/** An example command that uses an example subsystem. */
public class ManualArm extends CommandBase {
  private final Arm arm;
  private final CommandXboxController controller;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ManualArm(Arm arm, CommandXboxController controller) {
    this.arm = arm;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   arm.setArmPower(controller.getLeftY());

    
    // TODO: apply power to arm based on controller left Y
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // TODO: stop applying power (set to 0)
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
