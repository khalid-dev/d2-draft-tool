package d2draft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import skadistats.clarity.Clarity;
import skadistats.clarity.decoder.Util;
import skadistats.clarity.model.EngineType;
import skadistats.clarity.model.Entity;
import skadistats.clarity.model.FieldPath;
import skadistats.clarity.processor.entities.Entities;
import skadistats.clarity.processor.entities.UsesEntities;
import skadistats.clarity.processor.reader.OnMessage;
import skadistats.clarity.processor.runner.Context;
import skadistats.clarity.processor.runner.ControllableRunner;
import skadistats.clarity.processor.runner.SimpleRunner;
import skadistats.clarity.source.MappedFileSource;
import skadistats.clarity.source.Source;
import skadistats.clarity.util.TextTable;
import skadistats.clarity.wire.common.proto.Demo.CDemoFileInfo;
import skadistats.clarity.wire.s2.proto.S2UserMessages;

import java.io.IOException;
import java.util.*;

public class AllChatProcessor {
    @OnMessage(S2UserMessages.CUserMessageSayText2.class)
    //public void onM(Context ctx, S2UserMessages.CUserMessageSayText2 message) {
      //  System.out.format("%s: %s\n", message.getParam1(), message.getParam2());
    //}
   // public void cmonBruh(Context ctx, S2UserMessages.CUserMessageSayText2 message) {
    	//System.out.println("cmonBruh");
    //}
    public static void main(String[] args) throws Exception {
        // 1) create an input source from the replay
        Source source = new MappedFileSource("C:/Program Files (x86)/Steam/steamapps/common/dota 2 beta/game/dota/replays/3571979503.dem");
        // 2) create a simple runner that will read the replay once
        SimpleRunner runner = new SimpleRunner(source);
        // 3) create an instance of your processor
        AllChatProcessor processor = new AllChatProcessor();
        // 4) and hand it over to the runner
        runner.runWith(processor);    	
    }
}
