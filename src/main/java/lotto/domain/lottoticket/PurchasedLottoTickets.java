package lotto.domain.lottoticket;

import java.util.List;

public class PurchasedLottoTickets {

    private final LottoTickets manualLottoTickets;
    private final LottoTickets autoLottoTickets;

    public PurchasedLottoTickets() {
        manualLottoTickets = new LottoTickets();
        autoLottoTickets = new LottoTickets();
    }

    public void appendManualLottoTickets(List<LottoTicket> manualLottoTickets) {
        this.manualLottoTickets.append(manualLottoTickets);
    }

    public void appendManualLottoTickets(LottoTickets manualLottoTickets) {
        this.manualLottoTickets.append(manualLottoTickets);
    }

    public void appendAutoLottoTickets(List<LottoTicket> autoLottoTickets) {
        this.autoLottoTickets.append(autoLottoTickets);
    }

    public void appendAutoLottoTickets(LottoTickets autoLottoTickets) {
        this.autoLottoTickets.append(autoLottoTickets);
    }

    public int sizeOfManualLottoTickets() {
        return manualLottoTickets.size();
    }

    public int sizeOfAutoLottoTickets() {
        return autoLottoTickets.size();
    }

    @Override
    public String toString() {
        return manualLottoTickets.toString() + autoLottoTickets.toString();
    }
}
