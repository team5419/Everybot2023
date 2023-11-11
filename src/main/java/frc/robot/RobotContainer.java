// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArmToPosition;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.IntakeCube;
import frc.robot.commands.ManualArm;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;
import frc.robot.commands.IntakeCone;
import frc.robot.commands.OuttakePiece;
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Arm arm = new Arm();
  private final Intake intake = new Intake();
  private final Drive drive = new Drive();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(0);
  private final CommandXboxController m_codriverController = new CommandXboxController(1);

  // TODO: Declare and initialize the command(s)
  CommandBase defaultDrive = new DefaultDrive(drive, m_driverController);
  CommandBase manualArm = new ManualArm(arm, m_codriverController);
  CommandBase stopIntake = intake.stopIntakeCmd();
  CommandBase cubeIntake = new IntakeCube(intake);
  CommandBase coneIntake = new IntakeCone(intake);
  CommandBase outtakePiece = new OuttakePiece(intake);
  CommandBase zeroArm = new InstantCommand(() -> arm.zero());
  // TODO: IntakeCone, OuttakePiece

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
    arm.setDefaultCommand(manualArm);

    // MAP GAMEPAD BUTTONS TO COMMANDS
    // these are examples -- feel free to remap

    /* TODO: ARM POSITION CONTROL */
    // use DPAD for positions, may need to use game piece int to adjust target height
    // m_codriverController.povUp().onTrue(highCone);

    // whileTrue -- schedules when pressed, cancels when released
    /* TODO: INTAKE - can adjust mapping */
    // m_codriverController.x().whileTrue(cubeIntake);
    m_codriverController.b().whileTrue(cubeIntake);
    m_codriverController.a().whileTrue(coneIntake);
    m_codriverController.x().whileTrue(outtakePiece);
    m_driverController.leftBumper().whileTrue(outtakePiece);
    m_codriverController.y().onTrue(stopIntake);
    m_codriverController.rightBumper().onTrue(zeroArm);
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
