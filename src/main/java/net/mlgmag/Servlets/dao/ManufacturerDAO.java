package net.mlgmag.Servlets.dao;

import net.mlgmag.Servlets.model.Manufacturer;

import java.util.UUID;

public interface ManufacturerDAO extends GenericDAO<Manufacturer,UUID>{
    Manufacturer getByName(String name);
}
