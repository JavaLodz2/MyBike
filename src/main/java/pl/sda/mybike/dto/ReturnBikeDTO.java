package pl.sda.mybike.dto;

public class ReturnBikeDTO {

    private Integer bikeId;
    private Integer stationId;

    public ReturnBikeDTO(Integer bikeId, Integer stationId) {
        this.bikeId = bikeId;
        this.stationId = stationId;
    }

    public ReturnBikeDTO() {
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }
}
