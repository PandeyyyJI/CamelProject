package com.ofss.Mapper;

import com.ofss.model.Address;
import com.ofss.model.MappedOutputPOJO;
import com.ofss.model.OutputPOJO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-19T12:57:00+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.15.1 (Oracle Corporation)"
)
@Component
public class IDataMapperImpl implements IDataMapper {

    @Override
    public MappedOutputPOJO OutputToMappedOutputDto(OutputPOJO unmappedOutput) {
        if ( unmappedOutput == null ) {
            return null;
        }

        MappedOutputPOJO mappedOutputPOJO = new MappedOutputPOJO();

        mappedOutputPOJO.setCustomerAddress1( unmappedOutputAddressAddress1( unmappedOutput ) );
        mappedOutputPOJO.setCustomerAddress2( unmappedOutputAddressAddress2( unmappedOutput ) );
        mappedOutputPOJO.setCustomerId( String.valueOf( unmappedOutput.getCustomerId() ) );
        mappedOutputPOJO.setCustomerName( unmappedOutput.getCustomerName() );
        mappedOutputPOJO.setCode( unmappedOutput.getCode() );

        return mappedOutputPOJO;
    }

    private String unmappedOutputAddressAddress1(OutputPOJO outputPOJO) {
        if ( outputPOJO == null ) {
            return null;
        }
        Address address = outputPOJO.getAddress();
        if ( address == null ) {
            return null;
        }
        String address1 = address.getAddress1();
        if ( address1 == null ) {
            return null;
        }
        return address1;
    }

    private String unmappedOutputAddressAddress2(OutputPOJO outputPOJO) {
        if ( outputPOJO == null ) {
            return null;
        }
        Address address = outputPOJO.getAddress();
        if ( address == null ) {
            return null;
        }
        String address2 = address.getAddress2();
        if ( address2 == null ) {
            return null;
        }
        return address2;
    }
}
