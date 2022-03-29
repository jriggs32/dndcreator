import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Dungeons{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a character name: ");
		String characterName = input.nextLine();
		
		System.out.print("Type the number of the class you want to choose: \n1. Barbarian" +
			"\n2. Bard\n3. Cleric\n4. Druid\n5. Fighter\n6. Monk\n7. Paladin\n8. Ranger" + 
			"\n9. Rogue\n10. Sorcerer\n11. Warlock\n12. Wizard\n");
		int dndClass = input.nextInt();

		//true false identifiers for player's class

		boolean barbarian, bard, cleric, druid, fighter, monk, paladin, ranger, rogue,
		sorc, wizard, warlock;
		barbarian = bard = cleric = druid = fighter = monk = paladin = ranger = rogue =
		sorc = wizard = warlock = false;
		String dndClassChoice = "";
		int dndSubclass = 0;
		String dndSubChoice = "";

		switch(dndClass){
		case 1: barbarian = true;
			dndClassChoice = "Barbarian";
			break;
		case 2: bard = true;
			dndClassChoice = "Bard";
			break;
		case 3: cleric = true;
			dndClassChoice = "Cleric";
			break;
		case 4: druid = true;
			dndClassChoice = "Druid";
			break;
		case 5: fighter = true;
			dndClassChoice = "Fighter";
			break;
		case 6: monk = true;
			dndClassChoice = "Monk";
			break;
		case 7: paladin = true;
			dndClassChoice = "Paladin";
			break;
		case 8: ranger = true;
			dndClassChoice = "Ranger";
			break;
		case 9: rogue = true;
			dndClassChoice = "Rogue";
			break;
		case 10: sorc = true;
			dndClassChoice = "Sorc";
			break;
		case 11: warlock = true;
			dndClassChoice = "Warlock";
			break;
		case 12: wizard = true;
			dndClassChoice = "Wizard";
			break;
		} 
		System.out.println("You are a " + dndSubChoice + " " + dndClassChoice);

		//race selection
		System.out.print("Type the number of the race you want to choose: \n1. Dwarf" +
			"\n2. Elf\n3. Halfling\n4. Human\n5. Dragonborn\n6. Gnome\n7. Half-Elf" +
			"\n8. Half-Orc\n9. Tiefling\n");
		int dndRace = input.nextInt();

		//true false identifiers for player's race
		boolean dwarf, elf, halfling, human, dragonborn, gnome, halfelf, halforc, tiefling = false;
		String dndRaceChoice = "";
		int dndSubraceChoice = 0;

		//stat initialization
		int strStat = 0; 
		int dexStat = 0;
		int conStat = 0;
		int intStat = 0;
		int wisStat = 0;
		int chaStat = 0;

		//subrace selection system
		switch(dndRace){
		case 1: dwarf = true;
			dndRaceChoice = "Dwarf";
			System.out.println("Please choose a subrace.\n1. Hill Dwarf (+2 CON) " + 
				" (+1 WIS)\n2. Mountain Dwarf (+2 STR) (+2 CON)");
			dndSubraceChoice = input.nextInt();
			switch(dndSubraceChoice){
			case 1: dndRaceChoice = "Hill Dwarf";
				conStat += 2;
				wisStat += 1;
			case 2: dndRaceChoice = "Mountain Dwarf";
				strStat += 2;
				conStat += 2;
			}
			break;
		case 2: elf = true;
			dndRaceChoice = "Elf";
			System.out.println("Please choose a subrace.\n1. High Elf (+2 DEX) " + 
				" (+1 INT)\n2. Wood Elf (+2 DEX) (+1 WIS)");
			dndSubraceChoice = input.nextInt();
			switch(dndSubraceChoice){
			case 1: dndRaceChoice = "High Elf";
				dexStat += 2;
				intStat += 1;
			case 2: dndRaceChoice = "Wood Elf";
				dexStat += 2;
				wisStat += 1;
			}
			break;
		case 3: halfling = true;
			dndRaceChoice = "Halfling";
			System.out.println("Please choose a subrace.\n1. Lightfoot Halfling (+2 DEX) " + 
				" (+1 CHA)\n2. Stout Halfling (+2 DEX) (+1 CON)");
			dndSubraceChoice = input.nextInt();
			switch(dndSubraceChoice){
			case 1: dndRaceChoice = "Lightfoot Halfling";
				dexStat += 2;
				chaStat += 1;
			case 2: dndRaceChoice = "Stout Halfling";
				dexStat += 2;
				conStat += 1;
			}
			break;
		case 4: human = true;
			dndRaceChoice = "Human";
			System.out.println("Human (+1 to all stats)");
			strStat ++;
			dexStat ++;
			conStat ++;
			intStat ++;
			wisStat ++;
			chaStat ++;
			break;
		case 5: dragonborn = true;
			dndRaceChoice = "Dragonborn";
			System.out.println("Dragonborn (+2 STR) (+1 CHA)");
			strStat += 2;
			chaStat += 1;
			break;
		case 6: gnome = true;
			dndRaceChoice = "Gnome";
			System.out.println("Please choose a subrace.\n1. Forest Gnome (+1 DEX) " + 
				" (+2 INT)\n2. Rock Gnome (+1 CON) (+2 INT)");
			dndSubraceChoice = input.nextInt();
			switch(dndSubraceChoice){
			case 1: dndRaceChoice = "Forest Gnome";
				dexStat ++;
				intStat += 2;
			case 2: dndRaceChoice = "Rock Gnome";
				intStat += 2;
				conStat ++;
			}
			break;
		case 7: halfelf = true;
			dndRaceChoice = "Half-Elf";
			System.out.println("Half-Elf (+2 CHA)");
			chaStat += 2;
			break;
		case 8: halforc = true;
			dndRaceChoice = "Half-Orc";
			System.out.println("Half-Orc (+2 DEX) (+1 CON)");
			dexStat += 2;
			conStat ++;
			break;
		case 9: tiefling = true;
			dndRaceChoice = "Tiefling";
			System.out.println("Tiefling (+2 CHA) (+1 INT)");
			intStat ++;
			chaStat += 2;
			break;
		}

		System.out.println(dndRaceChoice);

		//stat rolls system
		Random randomGenerator=new Random();
		int[] finalRollsArray = new int[6];
		int finalStat = 0;

		System.out.print("Your stat rolls are: ");
		for(int i =0; i < 6; i++){
			finalRollsArray[i] = statRolls();
			System.out.print(finalRollsArray[i] + " ");
		}


		//stat assignment
		System.out.println("\nStat options: STR, DEX, CON, INT, WIS, CHA");
		System.out.println("Type an option to assign to the stat rolled.");
		
		boolean strStatBoo, dexStatBoo, conStatBoo, intStatBoo, wisStatBoo, chaStatBoo;
		strStatBoo = dexStatBoo = conStatBoo = intStatBoo = wisStatBoo = chaStatBoo = false;

		for (int i = 0; i < finalRollsArray.length; i++){ 

			System.out.println("Select stat for: " + finalRollsArray[i]);
			String statAllo = input.nextLine();
			String statAlloLow = statAllo.toLowerCase(); //ISSUE WITH THIS TYPING BEFORE INPUT
			if (statAlloLow.equals("str") || statAlloLow.equals("dex") || statAlloLow.equals("wis") ||
				statAlloLow.equals("con") || statAlloLow.equals("int") || statAlloLow.equals("cha")){
				switch(statAlloLow){
				case "str":
					if (strStatBoo == false){
						strStat = finalRollsArray[i] + strStat;
					} else {
						System.out.println("You have already assigned the Strength stat!");
						i--;
					}
					strStatBoo = true;
					break;

				case "dex":
					if (dexStatBoo == false){
						dexStat = finalRollsArray[i] + dexStat;
					} else {
						System.out.println("You have already assigned the Dexterity stat!");
						i--;
					}
					dexStatBoo = true;
					break;
				case "con":
					if (conStatBoo == false){
						conStat = finalRollsArray[i] + conStat;
					} else {
						System.out.println("You have already assigned the Constitution stat!");
						i--;
					}
					conStatBoo = true;
					break;
				case "int":
					if (intStatBoo == false){
						intStat = finalRollsArray[i] + intStat;
					} else {
						System.out.println("You have already assigned the Intelligence stat!");
						i--;
					}
					intStatBoo = true;
					break;
				case "wis":
					if (wisStatBoo == false){
						wisStat = finalRollsArray[i] + wisStat;
					} else {
						System.out.println("You have already assigned the Wisdom stat!");
						i--;
					}
					wisStatBoo = true;
					break;
				case "cha":
					if (chaStatBoo == false){
						chaStat = finalRollsArray[i] + chaStat;
					} else {
						System.out.println("You have already assigned the Charisma stat!");
						i--;
					}
					chaStatBoo = true;
					break;
				}
			} else {
				System.out.print("Please enter: STR, DEX, CON, INT, WIS, CHA\n");
				i--;
			}

		}

		//using this to check if program is working, comment out when done
		System.out.println("Your stats are\n--------------\nSTR: " + strStat + "\nDEX: " + dexStat +
			"\nCON: " + conStat + "\nINT: " + intStat + "\nWIS: " + wisStat + "\nCHA: " + chaStat);
	}

		} */
		public static int statRolls(){
			Random randomGenerator=new Random();
			int[] statRollArray = new int[4];
			int finalStat = 0;
			for(int j = 0; j < 4; j++){
				int statRolls = randomGenerator.nextInt(5 + 1) + 1;
				statRollArray[j] = statRolls;
			}
			java.util.Arrays.sort(statRollArray);
			finalStat = statRollArray[1] + statRollArray[2] + statRollArray[3];
			
			return finalStat; 
		} 

		



	/* public static int races(int dndRace){


	} */
}