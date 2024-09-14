package com.hluther.model;

import com.hluther.entity.Advertisement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import static com.hluther.entity.AdvertisementDuration.ONE_DAY;
import static com.hluther.entity.AdvertisementDuration.ONE_WEEK;
import static com.hluther.entity.AdvertisementDuration.THREE_DAYS;
import static com.hluther.entity.AdvertisementDuration.TWO_WEEKS;
import static com.hluther.entity.AdvertisementType.IMAGE;
import static com.hluther.entity.AdvertisementType.TEXT;
import static com.hluther.entity.AdvertisementType.VIDEO;

public class AdvertisementModel {

    public List<Advertisement> getAdvertisementList() {
        return List.of(
                new Advertisement(
                        1L,
                        "John",
                        "Anuncio 1",
                        TEXT,
                        new BigDecimal("500.50"),
                        new Date(),
                        ONE_DAY,
                        true
                ),
                new Advertisement(
                        2L,
                        "Jane",
                        "Anuncio 2",
                        IMAGE,
                        new BigDecimal("1000.00"),
                        new Date(),
                        ONE_DAY,
                        false
                ),
                new Advertisement(
                        3L,
                        "John",
                        "Anuncio 3",
                        VIDEO,
                        new BigDecimal("1500.00"),
                        new Date(),
                        TWO_WEEKS,
                        true
                ),
                new Advertisement(
                        4L,
                        "Jane",
                        "Anuncio 4",
                        TEXT,
                        new BigDecimal("2000.00"),
                        new Date(),
                        ONE_WEEK,
                        true
                ),
                new Advertisement(
                        5L,
                        "John",
                        "Anuncio 5",
                        TEXT,
                        new BigDecimal("2500.00"),
                        new Date(),
                        THREE_DAYS,
                        true
                )
        );
    }
}
