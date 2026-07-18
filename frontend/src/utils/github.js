const REPOSITORY = "Vamsi1807/Students_api_project";

export function getCommitUrl(commitId) {

    return `https://github.com/${REPOSITORY}/commit/${commitId}`;

}

export function getBranchUrl(branch) {

    return `https://github.com/${REPOSITORY}/tree/${branch}`;

}