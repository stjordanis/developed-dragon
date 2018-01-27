package miner;

import wikipedia.WikipediaCache;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by joris on 1/26/18.
 */
public class DepthFirstWikipediaMiner {

    public void start(String article, int depth)
    {
        mine(article, 0, depth, new HashSet<String>());
    }

    private void mine(String article, int depth, int maxDepth, Set<String> mined)
    {
        if(depth >= maxDepth)
            return;
        if(mined.contains(article))
            return;

        System.out.println(depth + "/" + maxDepth + "\t" + article);
        Set<Integer> out = WikipediaCache.get().outgoing(article);
        mined.add(article);

        for(int toId : out)
            mine(WikipediaCache.get().lookup(toId), depth + 1, maxDepth, mined);
    }
}
