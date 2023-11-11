package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.Drive;
import frc.robot.commands.TimeDrive;

public class autoScoreAndMobility extends SequentialCommandGroup{
    private final Drive drivetrain;
    public autoScoreAndMobility(Drive drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(this.drivetrain);
        addCommands(
            // new TimeDrive(drivetrain, 0.0, 0.05, 1.0, true),
            // new TimeDrive(drivetrain, 0.0, 0.2, 1.0, false)
        );
    }
}
