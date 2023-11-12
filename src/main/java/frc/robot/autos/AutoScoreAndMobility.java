package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;
import frc.robot.commands.TimeDrive;
import frc.robot.commands.IntakeCone;
import frc.robot.commands.OuttakePiece;
import frc.robot.commands.ArmToPosition;

public class AutoScoreAndMobility extends SequentialCommandGroup{
    private final Drive drivetrain;
    private final Intake intake;
    private final Arm arm;
    public AutoScoreAndMobility(Drive drivetrain, Intake intake, Arm arm) {
        this.drivetrain = drivetrain;
        this.intake = intake;
        this.arm = arm;
        addRequirements(this.drivetrain);
        addCommands(
            // set robobt 16.5-17 inches away
            new IntakeCone(intake).withTimeout(0.3),
            Commands.parallel(
                new IntakeCone(intake).withTimeout(1.5),
                new ArmToPosition(arm, arm.armHigh, 0.6).withTimeout(1.5)
                ),
            new OuttakePiece(intake).withTimeout(1.8),
            new ArmToPosition(arm, 0, 0.6).withTimeout(1.7),
            Commands.parallel(
                new OuttakePiece(intake).withTimeout(0.7),
                new TimeDrive(drivetrain, 0.0, 0.4, 0.7)
            ),
            new TimeDrive(drivetrain, 0.0, 0.4, 1.1)
        );
    }
}
