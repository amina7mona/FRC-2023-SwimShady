// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.roboAutos.ChargeStation.ChargePlusMobility;
import frc.robot.commands.roboAutos.ChargeStation.ScoreHighConePlusEngage;
import frc.robot.commands.roboAutos.ChargeStation.ScoreHighCubePlusEngage;
import frc.robot.commands.roboAutos.ChargeStation.ScoreMidCubePlusEngage;
import frc.robot.commands.roboAutos.ChargeStation.stages.DockAndEngage;
import frc.robot.commands.roboAutos.mobility.MobilityOnly;
import frc.robot.commands.roboAutos.oneOnly.ScoreHighCone;
import frc.robot.commands.roboAutos.oneOnly.ScoreHighCube;
import frc.robot.commands.roboAutos.oneOnly.ScoreMidCone;
import frc.robot.commands.roboAutos.oneOnly.ScoreMidCube;
import frc.robot.commands.roboAutos.onePlusMobility.ConeHighPlusMobility;
import frc.robot.commands.roboAutos.onePlusMobility.ConeMidPlusMobility;
import frc.robot.commands.roboAutos.onePlusMobility.CubeHighPlusMobility;
import frc.robot.commands.roboAutos.onePlusMobility.CubeMidPlusMobility;
import frc.robot.commands.roboAutos.onePlusPickUp.ConeHighPlusPickUp;
import frc.robot.commands.roboAutos.onePlusPickUp.ConeMidPlusPickUp;
import frc.robot.commands.roboAutos.onePlusPickUp.CubeHighPickUp;
import frc.robot.commands.roboAutos.two.ScoreHighTwice;
import frc.robot.commands.roboAutos.two.ScoreHybridTwice;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.ColorSensor;
//import frc.robot.subsystems.ColorSensor;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Gyro;
import frc.robot.utils.Metrics;
import frc.robot.subsystems.IntakeAlternate;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final boolean TWO_DRIVER_MODE = true;

  PneumaticHub m_hub;
  ColorSensor m_colorSensor;
  Chassis m_chassis;
  //Intake m_intake;
  IntakeAlternate intake;
  Elevator m_elevator;
  Gyro m_gyro;
  //sLimeLight m_lLight;
  // Replace with CommandPS4Controller or CommandJoystick if needed

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_hub = new PneumaticHub(Constants.RobotMap.PCM_ID);
    m_colorSensor = new ColorSensor();
    //m_intake = new Intake(m_hub, null);
    intake = new IntakeAlternate();
    m_elevator = new Elevator(intake);
    intake.setElevator(m_elevator);
    m_gyro = new Gyro();
    m_chassis = new Chassis(m_hub, m_elevator);
    //m_lLight = new LimeLight();
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is
    // pressed,
    // cancelling on release.

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   */
  public Command getAutonomousCommand(String selectedAuto) {
    // To add a new option to the Auto Mode Picker, you need to make a change in
    //  three places: Just search (Ctrl+Shift+F) for AUTO_MODE_PICKER, and you'll
    //  find all three!
    // In this place, add a `case` for your Mode ID Name, and return a `new` of 
    //  your Command class. 
    switch (selectedAuto) {
      case Robot.kNoAuto: return null;
      case Robot.kBalance: return new DockAndEngage(m_chassis,m_gyro);
      case Robot.kScoreConePlusBalance: return new ScoreHighConePlusEngage(m_elevator, intake, m_chassis, m_gyro);
      case Robot.kScoreCubeHighPlusBalance: return new ScoreHighCubePlusEngage(m_elevator, intake, m_chassis, m_gyro);
      case Robot.kMobilityAuto: return new MobilityOnly(m_chassis, m_gyro);
      case Robot.kScoreHighCone: return new ScoreHighCone(m_elevator, intake,m_chassis,m_gyro);
      case Robot.kScoreHighCube: return new ScoreHighCube(m_elevator, intake,m_chassis,m_gyro);
      case Robot.kConeHighPlusMobility: return new ConeHighPlusMobility(m_chassis, m_gyro, m_elevator, intake);
      case Robot.kCubeHighPlusMobility: return new CubeHighPlusMobility(m_chassis, m_gyro, m_elevator, intake);
      case Robot.kConeHighPlusPickup: return new ConeHighPlusPickUp(m_chassis, m_gyro, m_elevator, intake);
      case Robot.kCubeHighPlusPickup: return new CubeHighPickUp(m_elevator, intake, m_chassis, m_gyro);
      case Robot.kScoreHighTwiceAuto: return new ScoreHighTwice(m_chassis, m_gyro, m_elevator, intake);
      case Robot.kScoreHybridTwiceAuto: return new ScoreHybridTwice(m_chassis, m_gyro, m_elevator, intake);
      case Robot.kScoreMidConeOnly: return new ScoreMidCone(m_elevator, intake, m_chassis, m_gyro);
      case Robot.kScoreMidCUbeOnly: return new ScoreMidCube(m_elevator, intake, m_chassis, m_gyro);
      case Robot.kScoreMidConeMobility: return new ConeMidPlusMobility(m_chassis, m_gyro, m_elevator, intake);
      case Robot.kScoreMidCUbeMobility: return new CubeMidPlusMobility(m_chassis, m_gyro, m_elevator, intake);
      case Robot.kScoreMidConeEngage: return new ScoreHighConePlusEngage(m_elevator, intake, m_chassis, m_gyro);
      case Robot.kScoreMidCUbeEngage: return new ScoreMidCubePlusEngage(m_elevator, intake, m_chassis, m_gyro);
      case Robot.kScoreMidConePickUp: return new ConeMidPlusPickUp(m_chassis, m_gyro, m_elevator, intake);
      case Robot.kCHampsAuto: return new ChargePlusMobility(m_elevator, intake, m_chassis, m_gyro);

      default: return null;
    }    
  }

  public void periodic() {
    final String metric_key = "RobotContainer::periodic";
    Metrics.startTimer(metric_key);
    periodic_impl();
    Metrics.stopTimer(metric_key);
  }

  public void periodic_impl()
  {
    try {
      m_chassis.periodic();
    } catch (Exception e) { /* Don't die if the chassis dies */}
    try {
      m_elevator.periodic();
    } catch (Exception e) { /* Don't die if the elevator dies */}
    try {
      //m_intake.periodic();
      intake.periodic();
    } catch (Exception e) { /* Don't die if the intake dies */}
    try {
      m_gyro.periodic();
    } catch (Exception e) { /* Don't die if the gyro dies */}
    try {
      m_colorSensor.periodic();
    } catch (Exception e) { /* Don't die if the colorsensor dies. */ }
    try {
      //m_lLight.periodic();
    } catch (Exception e) { /* Don't die if the colorsensor dies. */ }
  }

  public void teleopPeriodic() {
    final String metric_key = "RobotContainer::teleopPeriodic";
    Metrics.startTimer(metric_key);
    teleopPeriodic_impl();
    Metrics.stopTimer(metric_key);
  }

  public void teleopPeriodic_impl()
  {
    /*
    ElevatorState elevatorState = RobotStates.ElevatorState.ELEVATOR_UNKNOWN;
    try {
      elevatorState = m_elevator.getState();
    } catch (Exception e) { }
    */
    try {
      m_chassis.teleopPeriodic();
    } catch (Exception e) { /* Don't die if we fail to run the chassis */}
    try {
      m_elevator.teleopPeriodic();
    } catch (Exception e) { /* Don't die if we fail to run the elevator */}
    try {
      //m_intake.teleopPeriodic();
      intake.teleopPeriodic();
    } catch (Exception e) { /* Don't die if we fail to run the intake */}
  }

  public void resetTiltOffset()
  {
    m_gyro.resetTiltOffset();
  }

  public void resetEncoders() {
    m_gyro.reset();
    m_chassis.resetEncoders();
    //m_intake.resetIntakeEncoder();
  }

  public void setChassisCoast(){
    m_chassis.setCoast();
  }

  public void setChassisBrake(){
    m_chassis.setBrake();
  }

  public void setLEDMode(boolean teleop){
    m_colorSensor.setTeleop(teleop);
  }
}
