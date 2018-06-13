package d2draft;

import java.util.ArrayList;
import java.util.HashMap;

import skadistats.clarity.wire.common.proto.Demo.CDemoFileInfo;
import skadistats.clarity.wire.common.proto.Demo.CGameInfo.CDotaGameInfo.CHeroSelectEvent;

public class Replay {
	private transient CDemoFileInfo source;
	private String radiantTeam;
	private String direTeam;
	private String winningTeam;
	private String winningTeamSide;
	private double gameDuration;
	//FP = First Pick, SP = Second Pick
	private String teamFP;
	private String teamSP;
	//Have separate Rad/Dire P/B and P/B location/phases down below for easy printing; minimizes processing on frontend.
	private ArrayList<String> radiantBans = new ArrayList<String>();
	private ArrayList<String> direBans = new ArrayList<String>();
	private ArrayList<String> radiantPicks = new ArrayList<String>();
	private ArrayList<String> direPicks = new ArrayList<String>();
	//First Pick phase 1 bans, Second Pick phase 1 bans
	private String[] FPp1Bans;
	private String[] SPp1Bans;
	//first pick
	private String FPp1Pick1;
	//opening pair
	private String[] SPp1Picks;
	//last pick of first phase
	private String FPp1Pick2;
	private String SPp2Ban1;
	private String FPp2Ban1;
	private String SPp2Ban2;
	private String FPp2Ban2;
	//first pick of second phase
	private String SPp2Pick1;
	private String FPp2Pick1;
	private String SPp2Pick2;
	//last pick of second phase
	private String FPp2Pick2;
	private String SPp3Ban;
	private String FPp3Ban;
	private String FPp3Pick;
	//last pick
	private String SPp3Pick;
	public Replay(CDemoFileInfo source) {
		this.source = source;
		this.radiantTeam = source.getGameInfo().getDota().getRadiantTeamTag();
		this.direTeam = source.getGameInfo().getDota().getDireTeamTag();
		if (source.getGameInfo().getDota().getGameWinner()==2) {
			this.winningTeamSide = "Radiant";
			this.winningTeam = this.radiantTeam;
		}
		if (source.getGameInfo().getDota().getGameWinner()==3) {
			this.winningTeamSide = "Dire";
			this.winningTeam = this.direTeam;
		}
		//Not sure if this math is right--check it ZULUL
		this.gameDuration = (double)(source.getGameInfo().getDota().getEndTime())/36000000;
		if (source.getGameInfo().getDota().getPicksBans(0).getTeam()==2) {
			this.teamFP = "Radiant";
			this.teamSP = "Dire";
		}
		if (source.getGameInfo().getDota().getPicksBans(0).getTeam()==3) {
			this.teamFP = "Dire";
			this.teamSP = "Radiant";
		}
		this.assignPB();
	}
	public void assignPB() {
		for (CHeroSelectEvent e: this.source.getGameInfo().getDota().getPicksBansList()) {
			if (e.getTeam()==2) {
				if (e.getIsPick())
					radiantPicks.add(""+e.getHeroId());
				else 
					radiantBans.add(""+e.getHeroId());
			}
			if (e.getTeam()==3) {
				if (e.getIsPick())
					direPicks.add(""+e.getHeroId());
				else
					direBans.add(""+e.getHeroId());
			}
		}
		//Change below if drafting order/p/b gets patched in the future.
		if (this.teamFP=="Radiant") {
			FPp1Bans = new String[]{radiantBans.get(0), radiantBans.get(1), radiantBans.get(2)};
			SPp1Bans = new String[]{direBans.get(0), direBans.get(1), direBans.get(2)};
			FPp1Pick1 = radiantPicks.get(0);
			SPp1Picks = new String[]{direPicks.get(0), direPicks.get(1)};
			FPp1Pick2 = radiantPicks.get(1);
			SPp2Ban1 = direBans.get(3);
			FPp2Ban1 = radiantBans.get(3);
			SPp2Ban2 = direBans.get(4);
			FPp2Ban2 = radiantBans.get(4);
			SPp2Pick1  = direPicks.get(2);
			FPp2Pick1 = radiantPicks.get(2);
			SPp2Pick2 = direPicks.get(3);
			FPp2Pick2 = radiantPicks.get(3);
			SPp3Ban = direBans.get(5);
			FPp3Ban = radiantBans.get(5);
			FPp3Pick = radiantPicks.get(4);
			SPp3Pick = direPicks.get(4);
		}
		if (this.teamFP=="Dire") {
			FPp1Bans = new String[]{direBans.get(0), direBans.get(1), direBans.get(2)};
			SPp1Bans = new String[]{radiantBans.get(0), radiantBans.get(1), radiantBans.get(2)};
			FPp1Pick1 = direPicks.get(0);
			SPp1Picks = new String[]{radiantPicks.get(0), radiantPicks.get(1)};
			FPp1Pick2 = direPicks.get(1);
			SPp2Ban1 = radiantBans.get(3);
			FPp2Ban1 = direBans.get(3);
			SPp2Ban2 = radiantBans.get(4);
			FPp2Ban2 = direBans.get(4);
			SPp2Pick1  = radiantPicks.get(2);
			FPp2Pick1 = direPicks.get(2);
			SPp2Pick2 = radiantPicks.get(3);
			FPp2Pick2 = direPicks.get(3);
			SPp3Ban = radiantBans.get(5);
			FPp3Ban = direBans.get(5);
			FPp3Pick = direPicks.get(4);
			SPp3Pick = radiantPicks.get(4);
		}
	}
}
