package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.common.LottoRank;

public class LottoStatistics {
    private final Map<LottoRank, Integer> results = new HashMap<>();

    public LottoStatistics() {
        Arrays.stream(LottoRank.values()).forEachOrdered(rank -> results.put(rank, 0));
    }

    public void recordResult(LottoRank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public Map<LottoRank, Integer> getResults() {
        return results;
    }
}

