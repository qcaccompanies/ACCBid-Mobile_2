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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

Mobile.startApplication('C:\\Users\\15421\\git\\ACCBid-Mobile2\\accbid.apk', false)

Mobile.tap(findTestObject('Kalkulator/BTN_Kalkulator'), 0)

Mobile.setText(findTestObject('Kalkulator/HargaUnit'), HargaUnit, 0)

if (varPeriode == '12') {
    CustomKeywords.'mobile.Slider.Slided'(findTestObject('Object Repository/Kalkulator/PeriodeSlider'), 0, FailureHandling.OPTIONAL)
} else if (varPeriode == '24') {
    CustomKeywords.'mobile.Slider.Slided'(findTestObject('Object Repository/Kalkulator/PeriodeSlider'), 0.25, FailureHandling.OPTIONAL)
} else if (varPeriode == '36') {
    CustomKeywords.'mobile.Slider.Slided'(findTestObject('Object Repository/Kalkulator/PeriodeSlider'), 0.5, FailureHandling.OPTIONAL)
} else if (varPeriode == '48') {
    CustomKeywords.'mobile.Slider.Slided'(findTestObject('Object Repository/Kalkulator/PeriodeSlider'), 0.75, FailureHandling.OPTIONAL)
} else if (varPeriode == '60') {
    CustomKeywords.'mobile.Slider.Slided'(findTestObject('Object Repository/Kalkulator/PeriodeSlider'), 1, FailureHandling.OPTIONAL)
}

Mobile.setText(findTestObject('Kalkulator/UangMukaRP'), UangMukaRp, 0)

if (Mobile.verifyElementVisible(findTestObject('Kalkulator/MinimalUangMuka'), 3, FailureHandling.OPTIONAL)) {
    Mobile.setText(findTestObject('Kalkulator/UangMuka'), UangMukaPersen, 0)

    Mobile.tap(findTestObject('Kalkulator/DropDownAreaPengajuan'), 0)

    Mobile.tap(findTestObject('Kalkulator/Click', [('text') : varAreaPengajuan]), 0)

    CustomKeywords.'ScrollUpDown.UpDown'(86, 2185, 86, 2185)

    Mobile.tap(findTestObject('Kalkulator/DropDownCabang'), 0)

    Mobile.tap(findTestObject('Kalkulator/Click', [('text') : varCabang]), 0)

    'Jenis Pembayaran'
    if (varPembayaran == 'Tunai') {
        Mobile.checkElement(findTestObject('Kalkulator/CheckBoxTunai'), 0)
    } else if (varPembayaran == 'Kredit') {
        Mobile.checkElement(findTestObject('Kalkulator/CheckBoxKredit'), 0)
    }
    
    if (varCreditProtection == 'Ya') {
        Mobile.checkElement(findTestObject('Kalkulator/CheckBoxCreditProtection'), 0)
    } else if (varCreditProtection == 'Tidak') {
        Mobile.uncheckElement(findTestObject('Kalkulator/CheckBoxCreditProtection'), 0)
    }
    
    Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)
} else {
    Mobile.tap(findTestObject('Kalkulator/DropDownAreaPengajuan'), 0)

    Mobile.tap(findTestObject('Kalkulator/Click', [('text') : varAreaPengajuan]), 0)

    CustomKeywords.'ScrollUpDown.UpDown'(86, 2185, 86, 2185)

    Mobile.tap(findTestObject('Kalkulator/DropDownCabang'), 0)

    Mobile.tap(findTestObject('Kalkulator/Click', [('text') : varCabang]), 0)

    'Jenis Pembayaran'
    if (varPembayaran == 'Tunai') {
        Mobile.checkElement(findTestObject('Kalkulator/CheckBoxTunai'), 0)
    } else if (varPembayaran == 'Kredit') {
        Mobile.checkElement(findTestObject('Kalkulator/CheckBoxKredit'), 0)
    }
    
    if (varCreditProtection == 'Ya') {
        Mobile.checkElement(findTestObject('Kalkulator/CheckBoxCreditProtection'), 0)
    } else if (varCreditProtection == 'Tidak') {
        Mobile.uncheckElement(findTestObject('Kalkulator/CheckBoxCreditProtection'), 0)
    }
    
    Mobile.pressBack()
}

switch ('Result') {
    case 'Pass':
        Mobile.pressBack()
    case 'Fail':
        if (Detail.toString() == 'Uang Muka Harus 20%') {
            Mobile.pressBack()
        }
        
        break
}

