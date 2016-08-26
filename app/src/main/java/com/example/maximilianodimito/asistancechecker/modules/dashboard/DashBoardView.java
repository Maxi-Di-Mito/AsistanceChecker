package com.example.maximilianodimito.asistancechecker.modules.dashboard;

import com.example.maximilianodimito.asistancechecker.model.Asistance;
import com.example.maximilianodimito.asistancechecker.model.Person;

import java.util.List;

/**
 * Created by maximiliano.dimito on 8/23/2016.
 */
public interface DashBoardView {

    void setAsistancesList(List<Asistance> persons);

}
