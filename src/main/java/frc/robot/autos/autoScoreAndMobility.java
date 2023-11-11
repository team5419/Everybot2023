package frc.robot.autos;

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
            new IntakeCone(intake),
            new ArmToPosition(arm, 0, 0),
            new OuttakePiece(intake),
            new ArmToPosition(arm, 0, 0),
            new TimeDrive(drivetrain, 0.0, 0.5, 0.5)
        );
    }
}
