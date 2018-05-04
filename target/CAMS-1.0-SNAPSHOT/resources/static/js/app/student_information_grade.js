
var value = ['2014', '2015', '2017', '2018', '2019', '2020', '2021', '2022', '2023', '2024']

function pickGrade() {
    var pickerDevice = app.picker.create({
        inputEl: '#picker-grade',
        cols: [
            {
                textAlign: 'center',
                values: value,
            }
        ]
    });
}