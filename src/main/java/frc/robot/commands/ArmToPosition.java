package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmToPosition extends CommandBase {
  // private final Arm arm;
  // private final int target;
  // private final int tolerance;

  public ArmToPosition(Arm arm, int target, int tolerance) {
    // this.arm = arm;
    // this.target = target;
    // this.tolerance = tolerance;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // TODO: SET GOAL POSITION ON MOTOR
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // If running a fancy motion profile, do the math based on the position & error
    // e.g. check for certain conditions, update the output
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // TODO: IF NOT INTERRUPTED -- STOP ARM
    if (interrupted == false) {
      
    }
    // BONUS: SHOW THAT WE'VE REACHED THE END WITH A COLOR INDICATOR ON SHUFFLEBOARD
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // TODO: IS FINISHED WHEN THE MOTOR TICKS IS WITHIN RANGE OF THE TARGET
    return false;
  }
}
