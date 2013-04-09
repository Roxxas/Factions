package com.massivecraft.factions.util;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.FactionColl;
import com.massivecraft.factions.Factions;

public class EconLandRewardTask implements Runnable {

	double rate;
	
	public EconLandRewardTask()
	{
		this.rate = Conf.econLandRewardTaskRunsEveryXMinutes;
	}

	@Override
	public void run()
	{
		FactionColl.i.econLandRewardRoutine();
		// maybe setting has been changed? if so, restart task at new rate
		if (this.rate != Conf.econLandRewardTaskRunsEveryXMinutes)
			Factions.get().startEconLandRewardTask(true);
	}

}