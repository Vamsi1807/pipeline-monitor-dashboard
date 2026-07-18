export function formatDate(date) {

    return new Date(date).toLocaleString();

}

export function formatDuration(milliseconds) {

    if (milliseconds < 1000) {

        return `${milliseconds} ms`;

    }

    return `${(milliseconds / 1000).toFixed(2)} sec`;

}