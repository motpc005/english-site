document.addEventListener('DOMContentLoaded', function () {

    const currentPath = window.location.pathname;

    document.querySelectorAll('.public-nav a, .toeic-nav a').forEach(link => {
        const href = link.getAttribute('href');

        if (href === '/' ? currentPath === '/' : currentPath === href || currentPath.startsWith(href + '/')) {
            link.classList.add('active');
        }
    });

}); 