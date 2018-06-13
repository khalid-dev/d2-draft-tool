package d2draft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class HeroHash {
	private ArrayList<Hero> data = new ArrayList<Hero>();
	public HeroHash() {
		//1 to 3 scale, 0 if none of the attribute exists for the hero
		//0 = non existent, 1 = bare minimum, 2 = decent, 3 = good
		//teamFight, waveClear, catch, towerPush, burst, counterInitiate, disengage, lanePressure, rosh, splitPush
		data.add(new Hero(0, new String[]{"N/A"}, "XHeroNoExist", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(1, new String[]{"Carry"}, "Anti-Mage", 1, 2, 1, 2, 1, 0, 3, 2, 0, 3));
		data.add(new Hero(2, new String[]{"Offlane"}, "Axe", 2, 1, 3, 0, 2, 3, 0, 2, 0, 1));
		data.add(new Hero(3, new String[]{"Support"}, "Bane", 1, 0, 3, 0, 1, 2, 2, 3, 0, 0));
		data.add(new Hero(4, new String[]{"Carry", "Mid"}, "Bloodseeker", 2, 2, 2, 1, 0, 0, 0, 1, 1, 0));
		data.add(new Hero(5, new String[]{"Support"}, "Crystal Maiden", 3, 1, 1, 0, 1, 1, 0, 0, 0, 1));
		data.add(new Hero(6, new String[]{"Carry"}, "Drow Ranger", 1, 1, 1, 3, 0, 1, 1, 2, 3, 2));
		data.add(new Hero(7, new String[]{"Offlane", "Support"}, "Earthshaker", 3, 0, 3, 0, 1, 3, 3, 0, 0, 0));
		data.add(new Hero(8, new String[]{"Carry"}, "Juggernaut", 1, 1, 0, 3, 2, 0, 0, 2, 2, 2));
		data.add(new Hero(9, new String[]{"Carry", "Mid", "Offlane", "Support"}, "Mirana", 1, 2, 1, 2, 1, 0, 0, 1, 2, 2));
		data.add(new Hero(10, new String[]{"Mid"}, "Shadow Fiend", 2, 3, 0, 2, 3, 0, 0, 3, 2, 2));
		data.add(new Hero(11, new String[]{"Carry"}, "Morphling", 3, 3, 0, 3, 3, 0, 1, 1, 1, 3));
		data.add(new Hero(12, new String[]{"Carry", "Mid"}, "Phantom Lancer", 0, 1, 0, 2, 0, 0, 2, 2, 1, 1));
		data.add(new Hero(13, new String[]{"Mid", "Offlane"}, "Puck", 3, 3, 3, 0, 2, 2, 2, 1, 0, 3));
		data.add(new Hero(14, new String[]{"Support"}, "Pudge", 1, 0, 3, 0, 1, 0, 0, 1, 0, 0));
		data.add(new Hero(15, new String[]{"Carry", "Mid", "Offlane"}, "Razor", 2, 1, 0, 1, 0, 0, 0, 3, 0, 0));
		data.add(new Hero(16, new String[]{"Offlane", "Support"}, "Sand King", 3, 2, 3, 0, 1, 3, 2, 2, 0, 1));
		data.add(new Hero(17, new String[]{"Mid"}, "Storm Spirit", 2, 2, 3, 0, 2, 1, 3, 1, 0, 3));
		data.add(new Hero(18, new String[]{"Carry"}, "Sven", 2, 3, 2, 1, 3, 2, 0, 1, 2, 1));
		data.add(new Hero(19, new String[]{"Carry", "Mid", "Offlane", "Support"}, "Tiny", 1, 2, 2, 3, 3, 1, 1, 2, 1, 1));
		data.add(new Hero(20, new String[]{"Carry", "Support"}, "Vengeful Spirit", 1, 0, 2, 3, 1, 2, 2, 1, 3, 0));
		data.add(new Hero(21, new String[]{"Mid", "Support"}, "Windrunner", 1, 3, 3, 2, 2, 1, 0, 2, 1, 2));
		data.add(new Hero(22, new String[]{"Mid", "Support"}, "Zeus", 3, 3, 0, 0, 3, 1, 0, 0, 0, 0));
		data.add(new Hero(23, new String[]{"Mid", "Support"}, "Kunkka", 3, 3, 3, 0, 2, 2, 1, 2, 0, 1));
		data.add(new Hero(24, new String[]{"N/A"}, "XHeroNoExist", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(25, new String[]{"Mid"}, "Lina", 1, 3, 1, 2, 3, 1, 0, 2, 1, 2));
		data.add(new Hero(26, new String[]{"Support"}, "Lich", 2, 1, 0, 0, 0, 3, 1, 3, 1, 0));
		data.add(new Hero(27, new String[]{"Support"}, "Lion", 2, 0, 3, 0, 2, 1, 0, 2, 0, 0));
		data.add(new Hero(28, new String[]{"Support"}, "Shadow Shaman", 1, 1, 3, 3, 0, 0, 0, 3, 2, 2));
		data.add(new Hero(29, new String[]{"Offlane", "Support"}, "Slardar", 2, 0, 3, 0, 2, 3, 3, 1, 3, 0));
		data.add(new Hero(30, new String[]{"Offlane"}, "Tidehunter", 3, 2, 1, 0, 0, 3, 1, 1, 2, 1));
		data.add(new Hero(31, new String[]{"Support"}, "Witch Doctor", 2, 1, 0, 1, 2, 2, 2, 3, 1, 0));
		data.add(new Hero(32, new String[]{"Support"}, "Riki", 1, 0, 1, 0, 2, 1, 0, 1, 1, 0));
		data.add(new Hero(33, new String[]{"Offlane"}, "Enigma", 3, 2, 3, 3, 1, 3, 0, 2, 1, 1));
		data.add(new Hero(34, new String[]{"Mid"}, "Tinker", 2, 3, 0, 0, 2, 0, 1, 3, 0, 3));
		data.add(new Hero(35, new String[]{"Mid"}, "Sniper", 1, 1, 0, 3, 0, 0, 0, 2, 0, 0));
		data.add(new Hero(36, new String[]{"Carry", "Mid", "Offlane"}, "Necrophos", 2, 2, 1, 0, 2, 1, 0, 1, 0, 0));
		data.add(new Hero(37, new String[]{"Support"}, "Warlock", 3, 1, 1, 1, 0, 3, 2, 2, 0, 0));
		data.add(new Hero(38, new String[]{"Offlane"}, "Beastmaster", 2, 3, 3, 3, 3, 0, 0, 2, 3, 3));
		data.add(new Hero(39, new String[]{"Mid", "Offlane"}, "Queen of Pain", 2, 2, 1, 1, 3, 0, 3, 3, 1, 2));
		data.add(new Hero(40, new String[]{"Carry", "Mid", "Offlane", "Support"}, "Venomancer", 3, 2, 1, 3, 0, 1, 0, 2, 0, 0));
		data.add(new Hero(41, new String[]{"Carry", "Offlane"}, "Faceless Void", 3, 0, 3, 1, 1, 3, 3, 2, 0, 2));
		data.add(new Hero(42, new String[]{"Carry", "Support"}, "Skeleton King", 2, 2, 2, 3, 0, 2, 0, 2, 1, 2));
		data.add(new Hero(43, new String[]{"Mid"}, "Death Prophet", 2, 3, 1, 3, 0, 0, 0, 2, 3, 0));
		data.add(new Hero(44, new String[]{"Carry", "Mid"}, "Phantom Assassin", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(45, new String[]{}, "Pugna", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(46, new String[]{}, "Templar Assassin", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(47, new String[]{}, "Viper", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(48, new String[]{}, "Luna", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(49, new String[]{}, "Dragon Knight", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(50, new String[]{}, "Dazzle", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(51, new String[]{}, "Clockwerk", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(52, new String[]{}, "Leshrac", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(53, new String[]{}, "Nature's Prophet", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(54, new String[]{}, "Lifestealer", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(55, new String[]{}, "Dark Seer", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(56, new String[]{}, "Clinkz", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(57, new String[]{}, "Omniknight", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(58, new String[]{}, "Enchantress", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(59, new String[]{}, "Huskar", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(60, new String[]{}, "Night Stalker", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(61, new String[]{}, "Broodmother", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(62, new String[]{}, "Bounty Hunter", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(63, new String[]{}, "Weaver", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(64, new String[]{}, "Jakiro", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(65, new String[]{}, "Batrider", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(66, new String[]{}, "Chen", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(67, new String[]{}, "Spectre", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		//monkaS 68 and 69--correct order? check with replay with AA or Doom picked
		data.add(new Hero(68, new String[]{}, "Ancient Apparition", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(69, new String[]{}, "Doom", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(70, new String[]{}, "Ursa", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(71, new String[]{}, "Spirit Breaker", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(72, new String[]{}, "Gyrocopter", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(73, new String[]{}, "Alchemist", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(74, new String[]{}, "Invoker", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(75, new String[]{}, "Silencer", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(76, new String[]{}, "Outworld Devourer", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(77, new String[]{}, "Lycanthrope", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(78, new String[]{}, "Brewmaster", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(79, new String[]{}, "Shadow Demon", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(80, new String[]{}, "Lone Druid", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(81, new String[]{}, "Chaos Knight", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(82, new String[]{}, "Meepo", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(83, new String[]{}, "Treant Protector", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(84, new String[]{}, "Ogre Magi", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(85, new String[]{}, "Undying", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(86, new String[]{}, "Rubick", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(87, new String[]{}, "Disruptor", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(88, new String[]{}, "Nyx Assassin", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(89, new String[]{}, "Naga Siren", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(90, new String[]{}, "Keeper of the Light", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(91, new String[]{}, "Io", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(92, new String[]{}, "Visage", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(93, new String[]{}, "Slark", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(94, new String[]{}, "Medusa", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(95, new String[]{}, "Troll Warlord", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(96, new String[]{}, "Centaur Warrunner", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(97, new String[]{}, "Magnus", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(98, new String[]{}, "Timbersaw", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(99, new String[]{}, "Bristleback", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(100, new String[]{}, "Tusk", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(101, new String[]{}, "Skywrath Mage", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(102, new String[]{}, "Abaddon", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(103, new String[]{}, "Elder Titan", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(104, new String[]{}, "Legion Commander", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(105, new String[]{}, "Techies", 0, 0 ,0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(106, new String[]{}, "Ember Spirit", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(107, new String[]{}, "Earth Spirit", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(108, new String[]{}, "Abyssal Underlord", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(109, new String[]{}, "Terrorblade", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(101, new String[]{}, "Phoenix", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(111, new String[]{}, "Oracle", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(112, new String[]{}, "Winter Wyvern", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(113, new String[]{}, "Arc Warden", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(114, new String[]{}, "Monkey King", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(115, new String[]{"N/A"}, "XHeroNoExist", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(116, new String[]{"N/A"}, "XHeroNoExist", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(117, new String[]{"N/A"}, "XHeroNoExist", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(118, new String[]{"N/A"}, "XHeroNoExist", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(119, new String[]{}, "Dark Willow", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		data.add(new Hero(120, new String[]{}, "Pangolier", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));	
	}
	public void randomizeHeroHash() {
		Random randomGenerator = new Random();
		for (int i = 0; i<this.data.size(); i++) {
			Hero temp = this.data.get(i);
			if (temp.getName()!="XHeroNoExist") {
				boolean isCarry = randomGenerator.nextBoolean();
				boolean isMid = randomGenerator.nextBoolean();
				boolean isOfflane = randomGenerator.nextBoolean();
				boolean isFarmingSupport = randomGenerator.nextBoolean();
				boolean isHardSupport = randomGenerator.nextBoolean();
				ArrayList<String> roles = new ArrayList<String>();
				if (isCarry)
					roles.add("Carry");
				if (isMid)
					roles.add("Mid");
				if (isOfflane)
					roles.add("Offlane");
				if (isFarmingSupport)
					roles.add("FarmingSupport");
				if (isHardSupport)
					roles.add("HardSupport");
				String[] rolesArr = new String[roles.size()];
				rolesArr = roles.toArray(rolesArr);
				temp.setRoles(rolesArr);
				temp.setTeamFight(randomGenerator.nextInt(4));
				temp.setWaveClear(randomGenerator.nextInt(4));
				temp.setCatchCapability(randomGenerator.nextInt(4));
				temp.setTowerPush(randomGenerator.nextInt(4));
				temp.setBurstDamage(randomGenerator.nextInt(4));
				temp.setCounterInitiate(randomGenerator.nextInt(4));
				temp.setDisengage(randomGenerator.nextInt(4));
				temp.setLanePressure(randomGenerator.nextInt(4));
				temp.setRoshTaking(randomGenerator.nextInt(4));
				temp.setSplitPush(randomGenerator.nextInt(4));
			}
		}
	}
	public ArrayList<Hero> getData() {
		return this.data;
	}
}
