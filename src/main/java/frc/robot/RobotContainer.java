// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArmToPosition;
import frc.robot.commands.DefaultDrive;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Arm arm = new Arm();
  private final Intake intake = new Intake();
  private final Drive drive = new Drive();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final XboxController m_driverController =
      new XboxController(OperatorConstants.kDriverControllerPort);

  // TODO: Declare and initialize the command(s)
  CommandBase defaultDrive = new DefaultDrive(drive, m_driverController);
  CommandBase highCone = new ArmToPosition(arm, 0, 0);
  CommandBase cubeIntake = intake.startCubeIntakeCommand();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Configure the default command for the drive subsystem
    // Scheduler will use the default command if no other command is using the subsystem
    drive.setDefaultCommand(defaultDrive);
    Map<String,Trigger> driverMap = new HashMap<>();

    driverMap.put("dpad", new Trigger(() -> m_driverController.getPOV() != -1));
    // whileTrue -- schedules when pressed, cancels when released
    driverMap.put("X", new Trigger(m_driverController::getXButton));

    // TODO: MAP GAMEPAD BUTTONS TO COMMANDS
    // these are examples -- feel free to remap
    driverMap.get("X").whileTrue(cubeIntake);
    // whileTrue -- schedules when pressed, cancels when released
    driverMap.get("dpad").onTrue(highCone);
    driverMap.get("X").onTrue(new PrintCommand("Print"));

    // Gets the boolean value of a button
    // m_driverController.getHID().getCrossButton()
    // Gets the trigger, which a command can be bound to
    //  m_driverController.cross()
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    // return Autos.exampleAuto(m_exampleSubsystem);
    return Commands.none();
  }
}
