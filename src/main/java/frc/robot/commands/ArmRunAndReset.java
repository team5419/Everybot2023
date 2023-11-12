package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drive;
import frc.robot.commands.TimeDrive;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake;

public class ArmHighReset extends SequentialCommandGroup{
    private final Arm arm;

    public ArmHighReset(Arm arm) {
        this.arm = arm;
        arm = new Arm();
        addRequirements(this.arm);
        addCommands(
            new ArmToPosition(arm, arm.armHigh, 1.5).withTimeout(0.5),
            new OuttakePiece(Intake).withTimeout(0.7),
            
        );
    }
}
