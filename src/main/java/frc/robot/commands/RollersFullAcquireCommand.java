/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class RollersFullAcquireCommand extends CommandGroup {

  public RollersFullAcquireCommand() {
    addParallel(new FloopPrepareForRollersCommand());
    addSequential(new RollersFullAcquire());
  }

  public class RollersFullAcquire extends Command {

    public RollersFullAcquire() {
      requires(Robot.rollers);
    }

    @Override
    protected void initialize() {
      Robot.toggleScore();
    }

    @Override
    protected void execute() {
      Robot.rollers.acquire();
    }

    @Override
    protected boolean isFinished() {
      return false;
    }

    @Override
    protected void end() {
      Robot.rollers.stop();
      Robot.toggleScore();
    }
  }
}
