// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.Timer;

/** An example command that uses an example subsystem. */
public class TimeDrive extends CommandBase {
  private final Drive drivetrain;
  private double steer;
  private double fwd;
  private Timer timer;
  private double endTime;
  private boolean jitter;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TimeDrive(Drive drivetrain, double steer, double fwd, double endTime, boolean jitter) {
    this.drivetrain = drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (jitter) {
      drivetrain.arcade(steer, fwd, false, false);
      drivetrain.arcade(steer, -fwd, false, false);
    } else {
      drivetrain.arcade(steer, fwd, false, false);
    }
 }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcade(0, 0, false, false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() > endTime;
  }
}