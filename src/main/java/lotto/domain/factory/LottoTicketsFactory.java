package lotto.domain.factory;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketsFactory {

    private final AutoLottoTicketFactory autoLottoTicketFactory;

    public LottoTicketsFactory(final AutoLottoTicketFactory autoLottoTicketFactory) {
        this.autoLottoTicketFactory = autoLottoTicketFactory;
    }

    public LottoTickets create(final List<String> inputManualLottoTickets, final int countOfAutoLottoPurchase) {
        final List<LottoTicket> manualLottoTickets = createManualLottoTickets(inputManualLottoTickets);
        final List<LottoTicket> autoLottoTickets = createAutoLottoTickets(countOfAutoLottoPurchase);
        manualLottoTickets.addAll(autoLottoTickets);

        return LottoTickets.of(manualLottoTickets);
    }

    private List<LottoTicket> createManualLottoTickets(final List<String> inputManualLottoTickets) {
        return inputManualLottoTickets.stream()
                .map(LottoUtils::parseLottoNumbers)
                .map(LottoTicket::of)
                .collect(Collectors.toList());
    }

    private List<LottoTicket> createAutoLottoTickets(final int countOfAutoLottoPurchase) {
        return IntStream.range(0, countOfAutoLottoPurchase)
                .mapToObj(x -> autoLottoTicketFactory.create())
                .collect(Collectors.toList())
                ;
    }
}
