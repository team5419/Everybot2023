package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drive;
import frc.robot.commands.TimeDrive;

public class AutoMobility extends SequentialCommandGroup{
    private final Drive drivetrain;
    public AutoMobility(Drive drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(this.drivetrain);
        addCommands(
            new TimeDrive(drivetrain, 0.0, 0.2, 0.2),
            new TimeDrive(drivetrain, 0.0, -0.2, 0.3),
            new TimeDrive(drivetrain, 0.0, 0.2, 0.2),
            new TimeDrive(drivetrain, 0.0, -0.2, 0.3),
            new TimeDrive(drivetrain, 0.0, 0.4, 1.0)
        );
    }
}
