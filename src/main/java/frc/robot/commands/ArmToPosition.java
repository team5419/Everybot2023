package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmToPosition extends CommandBase {
  private final Arm arm;
  private final int target;
  private final int tolerance;

  public ArmToPosition(Arm arm, int target, int tolerance) {
    this.arm = arm;
    this.target = target;
    this.tolerance = tolerance;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (target == 0){
      arm.TargetHigh();
    }
    if (target == 1){
      arm.TargetMedium();
    }
    if (target == 2){
      arm.TargetHigh();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.SetToPosition();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return arm.isAtPosition();
  }
}
