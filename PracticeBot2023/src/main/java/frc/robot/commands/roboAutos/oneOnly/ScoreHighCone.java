// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.roboAutos.oneOnly;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.roboActions.Combo.ElevatorGroundWhileWristAtOrigin;
import frc.robot.commands.roboActions.Combo.ElevatorHighWithWristSafe;
import frc.robot.commands.roboActions.intake.CloseClaw;
import frc.robot.commands.roboActions.intake.OpenClaw;
import frc.robot.commands.roboActions.wrist.WristConeScoringPosition;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.IntakeOld;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ScoreHighCone extends SequentialCommandGroup {
  /** Creates a new ScoreHighCone. */
  Elevator elevator;
  IntakeOld intake;
  public ScoreHighCone(Elevator elevator, IntakeOld intake) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    this.elevator = elevator;
    this.intake = intake;
    addCommands(
      new CloseClaw(intake)
      ,new ElevatorHighWithWristSafe(elevator, intake)
      ,new WristConeScoringPosition(intake)
      ,new OpenClaw(intake)
      ,new ElevatorGroundWhileWristAtOrigin(elevator, intake) 
    );
  }
}
