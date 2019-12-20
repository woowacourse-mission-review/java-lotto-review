package lotto.console.view;

import lotto.domain.Rank;
import lotto.domain.Result;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultFormat {
    public static List<String> format(final Result result) {
        return Stream.of(Rank.values())
                .map(rank -> message(result, rank))
                .collect(Collectors.toList())
                ;
    }

    private static String message(final Result result, final Rank rank) {
        if (rank == Rank.MISS) {
            return "";
        }

        return String.format("%d개 일치%s(%d원)- %d개",
                rank.getCountOfMatch(),
                rank.equals(Rank.SECOND) ? ", 보너스 볼 일치" : " ",
                rank.getPrize(),
                result.countOfRank(rank));
    }
}