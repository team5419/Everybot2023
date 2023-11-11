package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.Drive;
import frc.robot.commands.TimeDrive;

public class AutoScoreAndMobility extends SequentialCommandGroup{
    private final Drive drivetrain;
    public AutoScoreAndMobility(Drive drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(this.drivetrain);
        addCommands(
            new TimeDrive(drivetrain, 0.0, 0.5, 0.5)
        );
    }
}
