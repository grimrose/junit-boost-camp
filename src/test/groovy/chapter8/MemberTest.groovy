package chapter8

import org.hamcrest.CoreMatchers
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

import static org.junit.Assert.assertThat
import static org.junit.Assume.assumeTrue

@RunWith(Theories)
class MemberTest {

    @DataPoints
    public static int[] AGES = [15,20,25,30] as int[]

    @DataPoints
    public static Gender[] GENDERS = Gender.values()

    @Theory
    void "canEntryは25歳以下の女性の場合にtrueを返す"(int age, Gender gender) {
        assumeTrue age <= 25 && gender == Gender.FEMALE
        assertThat "When age=$age, genger=$gender", Member.canEntry(age, gender), CoreMatchers.is(true)
    }

    @Theory
    void "canEntryは25歳以下の女性でない場合にfalseを返す"(int age, Gender gender) {
        assumeTrue 25 < age || gender != Gender.FEMALE
        assertThat "When age=$age, genger=$gender", Member.canEntry(age, gender), CoreMatchers.is(false)
    }

}
