function toggleEdit() {
    const isEditable = $('#edit-btn').innerText === '저장';
    const tds = $('#title, #author, #create_date, #content');
    const editBtn = $('#edit-btn');

    if (isEditable) {
        // 저장 로직
        //inputs.forEach(input => input.setAttribute('disabled', true));
        editBtn.text('수정');  // 버튼을 다시 '수정'으로 변경
        alert('수정 내용이 저장되었습니다.'); // 저장 후 알림
    } else {
        // 수정 활성화
        //inputs.forEach(input => input.removeAttribute('disabled'));
        editBtn.text('저장');
    }
}

function showMessage () {
    alert('helloWorld!');
}