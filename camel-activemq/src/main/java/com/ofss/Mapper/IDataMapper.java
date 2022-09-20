package com.ofss.Mapper;

import com.ofss.model.MappedOutputPOJO;
import com.ofss.model.OutputPOJO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface IDataMapper {

    @Mapping(source = "address.address1", target="customerAddress1")
    @Mapping(source = "address.address2", target="customerAddress2")
    MappedOutputPOJO OutputToMappedOutputDto(OutputPOJO unmappedOutput);

}
