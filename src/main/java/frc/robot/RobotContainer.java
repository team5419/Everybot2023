// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.PrintCommand;
// import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArmToPosition;
import frc.robot.commands.DefaultDrive;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Arm arm = new Arm();
  private final Intake intake = new Intake();
  private final Drive drive = new Drive();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  // TODO: Declare and initialize the command(s)
  CommandBase defaultDrive = new DefaultDrive(drive, m_driverController);
  CommandBase highCone = new ArmToPosition(arm, 0, 0);
  CommandBase cubeIntake = intake.startCubeIntakeCommand();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  // To link buttons to commands, think about if you want the command to happen:
  //    - while the button is pressed
  //    - the moment the button is pressed (or released)
  //    - in relation to the level that the trigger/joystick is moved
  // Check out the API documentation for Xbox buttons & triggers here:
  // https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/wpilibj2/command/button/CommandXboxController.html
  private void configureBindings() {
    // Configure the default command for the drive subsystem
    // Scheduler will use the default command if no other command is using the subsystem
    drive.setDefaultCommand(defaultDrive);

    // TODO: MAP GAMEPAD BUTTONS TO COMMANDS
    // these are examples -- feel free to remap
    m_driverController.povUp().onTrue(highCone);
    // whileTrue -- schedules when pressed, cancels when released
    m_driverController.a().whileTrue(cubeIntake);

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
