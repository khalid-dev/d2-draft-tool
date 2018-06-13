package d2draft;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import skadistats.clarity.Clarity;
import skadistats.clarity.wire.common.proto.Demo.CDemoFileInfo;

public class Main {
	public static void main(String[] args) throws IOException {
		ArrayList<Replay> replays = new ArrayList<Replay>();
		File[] files = new File("replays").listFiles();
		for (File file: files) {
			CDemoFileInfo info = Clarity.infoForFile(file.getPath());
			Replay replay = new Replay(info);
			replays.add(replay);
		}
		Gson gson = new Gson();
		List<Replay> list = replays;
		Type type = new TypeToken<List<Replay>>() {}.getType();
		String json = gson.toJson(list, type);
		File file = new File("src/assets/replays.json");
		PrintWriter output = new PrintWriter(file);
        output.println(json);
        output.close();
        //heroes json
        file = new File("src/assets/heroes.json");
        output = new PrintWriter(file);
        HeroHash heroHash = new HeroHash();
        heroHash.randomizeHeroHash();
        ArrayList<Hero> heroes = heroHash.getData();
        List<Hero> listHeroes = heroes;
        Type typeHero = new TypeToken<List<Hero>>() {}.getType();
        String heroJson = gson.toJson(listHeroes, typeHero);
        output.println(heroJson);
        output.close();
        System.out.println(heroJson);
	}
}
