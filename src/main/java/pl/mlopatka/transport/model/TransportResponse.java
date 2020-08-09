package pl.mlopatka.transport.model;

import java.util.Objects;

public class TransportResponse {

    private final TransportStatus transportStatus;
    private final String note;

    private TransportResponse(TransportStatus transportStatus, String note) {
        this.transportStatus = transportStatus;
        this.note = note;
    }

    public static TransportResponse acceptedResponse() {
        return new TransportResponse(TransportStatus.ACCEPTED, "");
    }

    public static TransportResponse rejectedResponse(String note) {
        return new TransportResponse(TransportStatus.REJECTED, note);
    }

    public TransportStatus getTransportStatus() {
        return transportStatus;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportResponse that = (TransportResponse) o;
        return transportStatus == that.transportStatus &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transportStatus, note);
    }

    @Override
    public String toString() {
        return "TransportResponse{" +
                "transportStatus=" + transportStatus +
                ", note='" + note + '\'' +
                '}';
    }
}
