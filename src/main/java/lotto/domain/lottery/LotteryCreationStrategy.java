package lotto.domain.lottery;

import java.util.List;

public interface LotteryCreationStrategy {
   List<LotteryNumber> create();
}
