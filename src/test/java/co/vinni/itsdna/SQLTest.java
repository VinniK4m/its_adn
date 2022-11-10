package co.vinni.itsdna;

import co.vinni.itsdna.dialec.SQLiteDialect;
import co.vinni.itsdna.model.Statistics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SQLTest {

    private final SQLiteDialect sqLiteDialect;
    SQLTest(){
        sqLiteDialect = new SQLiteDialect();
    }
    @Test
    void supportsIdentityColumnsTest() {
        boolean rta= sqLiteDialect.supportsIdentityColumns();
        assertTrue(rta);
    }
    @Test
    void hasDataTypeInIdentityColumnTest() {
        boolean rta= sqLiteDialect.hasDataTypeInIdentityColumn();
        assertFalse(rta);
    }
    @Test
    void getIdentityColumnStringTest() {
        String rta= sqLiteDialect.getIdentityColumnString();
        assertTrue(rta.length()>0);
    }
    @Test
    void getIdentitySelectStringTest() {
        String rta= sqLiteDialect.getIdentitySelectString();
        assertTrue(rta.length()>0);
    }
    @Test
    void getLimitString() {
        boolean rta= sqLiteDialect.supportsTemporaryTables();
        assertTrue(rta);
    }
    @Test
    void getCreateTemporaryTableStringTest() {
        String rta= sqLiteDialect.getCreateTemporaryTableString();
        assertTrue(rta.length()>0);
    }
    @Test
    void dropTemporaryTableAfterUseTest() {
        boolean rta= sqLiteDialect.dropTemporaryTableAfterUse();
        assertFalse(rta);
    }
    @Test
    void supportsCurrentTimestampSelectionTest() {
        boolean rta= sqLiteDialect.supportsCurrentTimestampSelection();
        assertTrue(rta);
    }
    @Test
    void isCurrentTimestampSelectStringCallableTest() {
        boolean rta= sqLiteDialect.isCurrentTimestampSelectStringCallable();
        assertFalse(rta);
    }
    @Test
    void getCurrentTimestampSelectStringTest() {
        String rta= sqLiteDialect.getCurrentTimestampSelectString();
        assertTrue(rta.length() >0);
    }
    @Test
    void supportsUnionAllTest() {
        boolean rta= sqLiteDialect.supportsUnionAll();
        assertTrue(rta);
    }
    @Test
    void dropConstraintsTest() {
        boolean rta= sqLiteDialect.dropConstraints();
        assertFalse(rta);
    }
    @Test
    void getAddColumnStringTest() {
        String rta= sqLiteDialect.getAddColumnString();
        assertTrue(rta.length() >0);
    }
    @Test
    void supportsOuterJoinForUpdateTest() {
        boolean rta= sqLiteDialect.supportsUnionAll();
        assertTrue(rta);
    }
    @Test
    void getDropForeignKeyStringTest() {
        boolean error = false;
        try {
            sqLiteDialect.getDropForeignKeyString();

        }catch (UnsupportedOperationException e){
            error = true;
        }
        assertTrue(error);
    }
    @Test
    void supportsIfExistsBeforeTableNameTest() {
        boolean rta= sqLiteDialect.supportsIfExistsBeforeTableName();
        assertTrue(rta);
    }
    @Test
    void supportsCascadeDeleteTest() {
        boolean rta= sqLiteDialect.supportsCascadeDelete();
        assertFalse(rta);
    }

}
