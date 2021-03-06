package ru.android_studio.gibdd_servis.auto.response.history;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import ru.android_studio.gibdd_servis.auto.model.history.AutoType;
import ru.android_studio.gibdd_servis.auto.model.history.OwnershipPeriod;
import ru.android_studio.gibdd_servis.auto.model.history.ResponseStatus;
import ru.android_studio.gibdd_servis.auto.model.history.ResultAutoHistory;
import ru.android_studio.gibdd_servis.auto.model.history.TypeOwner;
import ru.android_studio.gibdd_servis.auto.model.history.Vehicle;
import ru.android_studio.gibdd_servis.auto.parser.ParseResultAutoHistory;

public class ParseResultAutoHistoryTest {

    ParseResultAutoHistory parseResultAutoHistory = ParseResultAutoHistory.getInstance();

    @Test
    public void testParseResult_SUCCESS_00000000000000000() {
        ResultAutoHistory result = new ResultAutoHistory();
        parseResultAutoHistory.mapSuccessResult(ResponseDataHistory.SUCCESS_00000000000000000, result);
        Assert.assertNotNull(result);

        ResultAutoHistory expected = new ResultAutoHistory();
        expected.setType(ResponseStatus.SUCCESS);

        Vehicle vehicle = new Vehicle();
        vehicle.setColor("ЗЕЛЕНЫЙ");
        vehicle.setBodyNumber("00000000000000000");
        vehicle.setYear("1983");
        vehicle.setModel("СЗАП 8352");
        vehicle.setVin("00000000000000000");
        vehicle.setCategory("Е");
        vehicle.setType(AutoType.a82);
        vehicle.setPowerKwt("0");

        expected.setVehicle(vehicle);

        Assert.assertEquals(expected.getVehicle(), result.getVehicle());
    }

    @Test
    public void testParseResult_SUCCESS_11111111111111111() {
        ResultAutoHistory result = new ResultAutoHistory();
        parseResultAutoHistory.mapSuccessResult(ResponseDataHistory.SUCCESS_11111111111111111, result);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result);
    }

    @Test
    public void testParseResult_SUCCESS_WP1AB29PX4LA69033() {
        ResultAutoHistory result = new ResultAutoHistory();
        String response = ResponseDataHistory.SUCCESS_WP1AB29PX4LA69033;
        parseResultAutoHistory.mapSuccessResult(response, result);
        Assert.assertNotNull(result);

        ResultAutoHistory expected = new ResultAutoHistory();
        expected.setType(ResponseStatus.SUCCESS);
        expected.setResponse(response);
        expected.setVin("00000000000000000");

        Vehicle vehicle = new Vehicle();
        vehicle.setColor("СЕРЫЙ");
        vehicle.setBodyNumber("WР1АВ29РХ4LА69033");
        vehicle.setYear("2003");
        vehicle.setModel("ПОРШЕ КАЙЕНН S");
        vehicle.setVin("WР1АВ29РХ4LА69033");
        vehicle.setCategory("В");
        vehicle.setType(AutoType.a21);
        vehicle.setPowerKwt("250");
        vehicle.setPowerHp("340");

        expected.setVehicle(vehicle);

        List<OwnershipPeriod> ownershipPeriodList = new ArrayList<>(6);

        OwnershipPeriod ownershipPeriod0 = new OwnershipPeriod();
        ownershipPeriod0.setId(String.valueOf(0));
        ownershipPeriod0.setFrom("2007-04-13T00:00:00.000+04:00");
        ownershipPeriod0.setTo("2007-06-07T00:00:00.000+04:00");
        ownershipPeriod0.setSimplePersonType(TypeOwner.NATURAL);
        ownershipPeriodList.add(ownershipPeriod0);
        OwnershipPeriod ownershipPeriod1 = new OwnershipPeriod();
        ownershipPeriod1.setId(String.valueOf(1));
        ownershipPeriod1.setFrom("2007-06-07T00:00:00.000+04:00");
        ownershipPeriod1.setTo("2008-09-10T00:00:00.000+04:00");
        ownershipPeriod1.setSimplePersonType(TypeOwner.NATURAL);
        ownershipPeriodList.add(ownershipPeriod1);
        OwnershipPeriod ownershipPeriod2 = new OwnershipPeriod();
        ownershipPeriod2.setId(String.valueOf(2));
        ownershipPeriod2.setFrom("2008-09-10T00:00:00.000+04:00");
        ownershipPeriod2.setTo("2009-08-01T00:00:00.000+04:00");
        ownershipPeriod2.setSimplePersonType(TypeOwner.NATURAL);
        ownershipPeriodList.add(ownershipPeriod2);
        OwnershipPeriod ownershipPeriod3 = new OwnershipPeriod();
        ownershipPeriod3.setId(String.valueOf(3));
        ownershipPeriod3.setFrom("2009-08-01T00:00:00.000+04:00");
        ownershipPeriod3.setTo("2011-02-24T00:00:00.000+03:00");
        ownershipPeriod3.setSimplePersonType(TypeOwner.NATURAL);
        ownershipPeriodList.add(ownershipPeriod3);
        OwnershipPeriod ownershipPeriod4 = new OwnershipPeriod();
        ownershipPeriod4.setId(String.valueOf(4));
        ownershipPeriod4.setFrom("2011-02-24T00:00:00.000+03:00");
        ownershipPeriod4.setTo("2015-02-17T00:00:00.000+03:00");
        ownershipPeriod4.setSimplePersonType(TypeOwner.NATURAL);
        ownershipPeriodList.add(ownershipPeriod4);
        OwnershipPeriod ownershipPeriod5 = new OwnershipPeriod();
        ownershipPeriod5.setId(String.valueOf(5));
        ownershipPeriod5.setFrom("2015-02-17T00:00:00.000+03:00");
        ownershipPeriod5.setTo("2015-04-06T00:00:00.000+03:00");
        ownershipPeriod5.setSimplePersonType(TypeOwner.NATURAL);
        ownershipPeriodList.add(ownershipPeriod5);
        OwnershipPeriod ownershipPeriod6 = new OwnershipPeriod();
        ownershipPeriod6.setId(String.valueOf(6));
        ownershipPeriod6.setFrom("2015-04-06T00:00:00.000+03:00");
        ownershipPeriod6.setTo(null);
        ownershipPeriod6.setSimplePersonType(TypeOwner.NATURAL);
        ownershipPeriodList.add(ownershipPeriod6);
        expected.setOwnershipPeriodList(ownershipPeriodList);

        Assert.assertEquals(expected, result);
    }
}