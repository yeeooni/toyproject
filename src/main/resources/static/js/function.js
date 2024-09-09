function toggleEdit() {
    const isEditable = document.getElementById('edit-btn').innerText === '저장';
    const inputs = document.querySelectorAll('#title, #author, #date, #content');
    const editBtn = document.getElementById('edit-btn');

    if (isEditable) {
        // 저장 로직
        inputs.forEach(input => input.setAttribute('disabled', true));
        editBtn.innerText = '수정';  // 버튼을 다시 '수정'으로 변경
        alert('수정 내용이 저장되었습니다.'); // 저장 후 알림
    } else {
        // 수정 활성화
        inputs.forEach(input => input.removeAttribute('disabled'));
        editBtn.innerText = '저장';  // 버튼을 '저장'으로 변경
    }
}

function showMessage () {
    alert('helloWorld!');
}