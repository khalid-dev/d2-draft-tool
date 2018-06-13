# d2-draft-tool
A single-page application designed to provide feedback on a Dota 2 draft, whether alongside the draft real time, or with the intent of strategizing outside the game itself. 
## Uploading Replays
* The user should put the replays they wish to use in the scrim_replays folder, then run the Main.java file in src/main.
* Currently using replays from the China Dota 2 Supermajor to demo the tool.
## Real Time Drafting
* The user is able to select whether they are first pick or second pick.
* The user is able to select heroes as if they were going through the drafting phase.
* The user may change a pick by clicking the draft location, then selecting the new hero.
* The user is able to filter all the dota heroes based on attributes and hero roles in order to find the perfect fit for their team.
    * Roles are "Carry", "Mid", "Offlane", "FarmingSupport", and "HardSupport"
    * Sums of these attributes are displayed both for your team and the enemy team.
    * Each hero's attributes and roles are randomized to preserve strategic value of the tool.
## Predicting Enemy Picks
* The user can select the team they are drafting against.
* After every enemy pick, all drafts of the chosen enemy team are parsed and a list of potential picks, accompanied by their corresponding probability, is generated based on previous trends in the team's drafts.
## Originally Uploaded on Gitlab
* https://gitlab.com/khusain/d2-draft-tool , see link for detailed commit history.

