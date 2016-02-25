package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.RetrofitAPI;
import com.nhpatt.asde.async.services.ApiaryService;
import com.nhpatt.asde.models.Event;

import java.util.List;

import rx.Observable;

/**
 * @author Hugo Nebreda
 */
public class SearchEventListInteractor extends AbstractInteractor {

    public Observable<List<Event>> runOnRx() {

        ApiaryService apiary = RetrofitAPI.getApiary().create(ApiaryService.class);
        return apiary.events().compose(applySchedulers());
    }
}
