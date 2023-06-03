// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.roboAutos.oneOnly;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.roboActions.Combo.GoHighSmooth;
import frc.robot.commands.roboActions.Combo.GoHome;
import frc.robot.commands.roboActions.intake.Eject;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.IntakeAlternate;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ScoreHighCone extends SequentialCommandGroup {
  /** Creates a new ScoreHighCone. */
  public ScoreHighCone(Elevator elevator, IntakeAlternate intake, Chassis chassis, Gyro gyro) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    //driveController = new PIDController(.011, .01, 0, 35, 5, 1, -Constants.Values.TICKS_PER_METER*.25);
    //straightHeadingController = new PIDController(.05, .007, 0, .15, .2, .2, 0);
    addCommands(
      new GoHighSmooth(intake, elevator)
      ,new WaitCommand(1)
      ,new Eject(intake)
      ,new GoHome(intake, elevator)
    );
  }
}
