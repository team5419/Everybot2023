// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

/** An example command that uses an example subsystem. */
public class DefaultDrive extends CommandBase {
  private final Drive drivetrain;
  private final CommandXboxController controller;
  public double steerConstant = 0.5;
  public double speedConstant = 0.7;
  public double slowConstant = 1.0;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DefaultDrive(Drive drivetrain, CommandXboxController controller) {
    this.drivetrain = drivetrain;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (controller.rightBumper().getAsBoolean()) {
      slowConstant = 0.5;
    } else {
      slowConstant = 1.0;
    }
    // drivetrain.arcade((-controller.getLeftY()*speedConstant + controller.getRightX() / steerConstant) * slowConstant, (controller.getLeftY() / speedConstant + controller.getRightX() / steerConstant) * slowConstant);
    drivetrain.arcade(controller.getLeftY(), controller.getLeftX());
  } 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcade(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}