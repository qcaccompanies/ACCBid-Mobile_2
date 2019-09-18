import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.detroitlabs.katalonmobileutil.testobject.XPathBuilder as XPathBuilder

Mobile.startApplication('C:\\Users\\15421\\Katalon Studio\\Magang\\intan\\acctesting\\accbid.apk', false)

Mobile.tap(findTestObject('akun'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('lihatprofil'), 0)

Mobile.tap(findTestObject('ubah_profil'), 0)

not_run: Mobile.tap(findTestObject('ubahnomorhandphone'), 0)

not_run: Mobile.setText(findTestObject('input_nomor_baru'), nomorhandphone, 0)

not_run: Mobile.tap(findTestObject('btn_konf_ganti_nomor'), 0)

Mobile.tap(findTestObject('ubah profil/ubahprofil_InpTanggalLahir'), 0)

WebUI.callTestCase(findTestCase('calendar'), [('varTahun') : '2000'], FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('ubahalamat'), alamat, 0)

if (Mobile.verifyElementExist(findTestObject('btn_konf_ganti_nomor'), 3, FailureHandling.STOP_ON_FAILURE)) {
    Mobile.checkElement(findTestObject(null), 0)
}

switch (expected.toString()) {
    case 'passed':
        Mobile.checkElement(findTestObject(null), 0)

        break
}

