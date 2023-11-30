export function formatDate(date: Date) {
	return (
		(date.getDate() < 10 ? `0${date.getDate()}` : date.getDate()) +
		'/' +
		(date.getMonth() + 1 < 10
			? `0${date.getMonth() + 1}`
			: date.getMonth() + 1) +
		'/' +
		date.getFullYear()
	);
}

export function formatTime(date: Date) {
  return (
    (date.getHours() < 10 ? `0${date.getHours()}` : date.getHours()) +
    ':' +
    (date.getMinutes() < 10
      ? `0${date.getMinutes()}`
      : date.getMinutes())
  );
}
