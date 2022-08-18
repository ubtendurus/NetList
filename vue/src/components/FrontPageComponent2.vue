<template>
  <body class="pt-28 pb-4">
    <h2 class="text-2xl leading-6 text-gray-800 text-center px-4">
      Testimonials
    </h2>
    <h1
      class="
        lg:text-5xl
        md:text-4xl
        text-2xl
        font-semibold
        px-4
        leading-10
        text-gray-800
        mt-6
        text-center
      "
    >
      What Our Users Say
    </h1>
    <div
      class="
        container
        mx-auto
        grid
        sm:grid-cols-1
        md:grid-cols-2
        lg:grid-cols-3
        xl:grid-cols-3 xl:px-20
        px-10
        py-20
        gap-6
      "
    >
      <div>
        <div
          class="
            group
            w-full
            bg-white
            relative
            flex flex-col
            items-center
            hover:bg-indigo-700
            cursor-pointer
            shadow-md
            md:p-12
            p-6
          "
        >
          <div
            class="
              text-gray-600
              group-hover:text-white
              flex flex-col
              items-center
            "
          >
            <svg
              width="26"
              height="27"
              viewBox="0 0 26 27"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <g clip-path="url(#clip0)">
                <path
                  d="M25.2578 14.3309H19.2969C19.3988 9.55819 20.6309 9.01642 22.1785 8.86178L22.7753 8.78051V3.53242L22.0874 3.57292C20.0666 3.69783 17.8323 4.09805 16.3417 6.11965C15.035 7.89183 14.459 10.7871 14.459 15.2316V23.4673H25.2578V14.3309Z"
                  fill="currentColor"
                />
                <path
                  d="M11.48 23.4673V14.3309H5.59859C5.70049 9.55819 6.89283 9.01642 8.44042 8.86178L8.99749 8.78051V3.53242L8.34931 3.57292C6.32844 3.69783 4.07421 4.09805 2.5836 6.11965C1.27707 7.89183 0.681147 10.7871 0.681147 15.2316V23.4673H11.48Z"
                  fill="currentColor"
                />
              </g>
              <defs>
                <clipPath id="clip0">
                  <rect
                    width="24.5767"
                    height="27"
                    fill="white"
                    transform="translate(25.2578 27) rotate(-180)"
                  />
                </clipPath>
              </defs>
            </svg>
            <p class="xl:w-80 text-base leading-normal text-center mt-4">
              Keeping track of grocery lists has never been easier. 
              Whether it's for stocking one of my many esteemed restaurants or to make sure I have the ingredients at home
              to make one of my legendary grilled cheese sandwiches, I know I'm 
              always prepared with NetList.
            </p>
          </div>
          <div
            class="
              text-white
              group-hover:text-indigo-700
              absolute
              bottom-0
              -mb-6
            "
          >
            <svg
              width="34"
              height="28"
              viewBox="0 0 34 28"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <g filter="url(#filter0_dd)">
                <path
                  d="M17 19L28.2583 3.25H5.74167L17 19Z"
                  fill="currentColor"
                />
              </g>
              <defs>
                <filter
                  id="filter0_dd"
                  x="0.741699"
                  y="0.25"
                  width="32.5167"
                  height="27.75"
                  filterUnits="userSpaceOnUse"
                  color-interpolation-filters="sRGB"
                >
                  <feFlood flood-opacity="0" result="BackgroundImageFix" />
                  <feColorMatrix
                    in="SourceAlpha"
                    type="matrix"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0"
                  />
                  <feMorphology
                    radius="1"
                    operator="erode"
                    in="SourceAlpha"
                    result="effect1_dropShadow"
                  />
                  <feOffset dy="4" />
                  <feGaussianBlur stdDeviation="3" />
                  <feColorMatrix
                    type="matrix"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.1 0"
                  />
                  <feBlend
                    mode="normal"
                    in2="BackgroundImageFix"
                    result="effect1_dropShadow"
                  />
                  <feColorMatrix
                    in="SourceAlpha"
                    type="matrix"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0"
                  />
                  <feOffset dy="2" />
                  <feGaussianBlur stdDeviation="2.5" />
                  <feColorMatrix
                    type="matrix"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.06 0"
                  />
                  <feBlend
                    mode="normal"
                    in2="effect1_dropShadow"
                    result="effect2_dropShadow"
                  />
                  <feBlend
                    mode="normal"
                    in="SourceGraphic"
                    in2="effect2_dropShadow"
                    result="shape"
                  />
                </filter>
              </defs>
            </svg>
          </div>
        </div>
        <div class="flex flex-col items-center justify-center mt-10">
          <img
            src="data:image/jpeg;base64,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"
            alt="profile pictre"
            class="w-12 h-12 rounded-full overflow-hidden shadow"
          />
          <p class="text-base font-semibold leading-4 my-2 text-gray-800">
            Gordon Ramsay
          </p>
          <p class="text-base leading-4 text-center text-gray-600">Professional Food Guy</p>
        </div>
      </div>
            
      <div>
        <div
          class="
            group
            w-full
            bg-white
            relative
            flex flex-col
            items-center
            hover:bg-indigo-700
            cursor-pointer
            shadow-md
            md:p-12
            p-6
          "
        >
          <div
            class="
              text-gray-600
              group-hover:text-white
              flex flex-col
              items-center
            "
          >
            <svg
              width="26"
              height="27"
              viewBox="0 0 26 27"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <g clip-path="url(#clip0)">
                <path
                  d="M25.2578 14.3309H19.2969C19.3988 9.55819 20.6309 9.01642 22.1785 8.86178L22.7753 8.78051V3.53242L22.0874 3.57292C20.0666 3.69783 17.8323 4.09805 16.3417 6.11965C15.035 7.89183 14.459 10.7871 14.459 15.2316V23.4673H25.2578V14.3309Z"
                  fill="currentColor"
                />
                <path
                  d="M11.48 23.4673V14.3309H5.59859C5.70049 9.55819 6.89283 9.01642 8.44042 8.86178L8.99749 8.78051V3.53242L8.34931 3.57292C6.32844 3.69783 4.07421 4.09805 2.5836 6.11965C1.27707 7.89183 0.681147 10.7871 0.681147 15.2316V23.4673H11.48Z"
                  fill="currentColor"
                />
              </g>
              <defs>
                <clipPath id="clip0">
                  <rect
                    width="24.5767"
                    height="27"
                    fill="white"
                    transform="translate(25.2578 27) rotate(-180)"
                  />
                </clipPath>
              </defs>
            </svg>
            <p class="xl:w-80 text-base leading-normal text-center mt-4">
              I'm a busy guy–I have films to shoot, cats to pet, and elderly citizens to give up my seat for on public transit.
              Even as a solo user, NetList allows me to keep all of my to-do lists in one convenient place. Now that's what I call a dodged bullet!
            </p>
          </div>
          <div
            class="
              text-white
              group-hover:text-indigo-700
              absolute
              bottom-0
              -mb-6
            "
          >
            <svg
              width="34"
              height="28"
              viewBox="0 0 34 28"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <g filter="url(#filter0_dd)">
                <path
                  d="M17 19L28.2583 3.25H5.74167L17 19Z"
                  fill="currentColor"
                />
              </g>
              <defs>
                <filter
                  id="filter0_dd"
                  x="0.741699"
                  y="0.25"
                  width="32.5167"
                  height="27.75"
                  filterUnits="userSpaceOnUse"
                  color-interpolation-filters="sRGB"
                >
                  <feFlood flood-opacity="0" result="BackgroundImageFix" />
                  <feColorMatrix
                    in="SourceAlpha"
                    type="matrix"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0"
                  />
                  <feMorphology
                    radius="1"
                    operator="erode"
                    in="SourceAlpha"
                    result="effect1_dropShadow"
                  />
                  <feOffset dy="4" />
                  <feGaussianBlur stdDeviation="3" />
                  <feColorMatrix
                    type="matrix"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.1 0"
                  />
                  <feBlend
                    mode="normal"
                    in2="BackgroundImageFix"
                    result="effect1_dropShadow"
                  />
                  <feColorMatrix
                    in="SourceAlpha"
                    type="matrix"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0"
                  />
                  <feOffset dy="2" />
                  <feGaussianBlur stdDeviation="2.5" />
                  <feColorMatrix
                    type="matrix"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.06 0"
                  />
                  <feBlend
                    mode="normal"
                    in2="effect1_dropShadow"
                    result="effect2_dropShadow"
                  />
                  <feBlend
                    mode="normal"
                    in="SourceGraphic"
                    in2="effect2_dropShadow"
                    result="shape"
                  />
                </filter>
              </defs>
            </svg>
          </div>
        </div>
        <div class="flex flex-col items-center justify-center mt-10">
          <img
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFwrDVBZWMI39qhhQZ9LMNWKX5tD7jNONI5Q&usqp=CAU"
            alt="profile pictre"
            class="w-12 h-12 rounded-full overflow-hidden shadow"
          />
          <p class="text-base font-semibold leading-4 my-2 text-gray-800">
            Keanu Reeves
          </p>
          <p class="text-base leading-4 text-center text-gray-600">Goodness Incarnate</p>
        </div>
      </div>
      <div>
        <div
          class="
            group
            w-full
            bg-white
            relative
            flex flex-col
            items-center
            hover:bg-indigo-700
            cursor-pointer
            shadow-md
            md:p-12
            p-6
          "
        >
          <div
            class="
              text-gray-600
              group-hover:text-white
              flex flex-col
              items-center
            "
          >
            <svg
              width="26"
              height="27"
              viewBox="0 0 26 27"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <g clip-path="url(#clip0)">
                <path
                  d="M25.2578 14.3309H19.2969C19.3988 9.55819 20.6309 9.01642 22.1785 8.86178L22.7753 8.78051V3.53242L22.0874 3.57292C20.0666 3.69783 17.8323 4.09805 16.3417 6.11965C15.035 7.89183 14.459 10.7871 14.459 15.2316V23.4673H25.2578V14.3309Z"
                  fill="currentColor"
                />
                <path
                  d="M11.48 23.4673V14.3309H5.59859C5.70049 9.55819 6.89283 9.01642 8.44042 8.86178L8.99749 8.78051V3.53242L8.34931 3.57292C6.32844 3.69783 4.07421 4.09805 2.5836 6.11965C1.27707 7.89183 0.681147 10.7871 0.681147 15.2316V23.4673H11.48Z"
                  fill="currentColor"
                />
              </g>
              <defs>
                <clipPath id="clip0">
                  <rect
                    width="24.5767"
                    height="27"
                    fill="white"
                    transform="translate(25.2578 27) rotate(-180)"
                  />
                </clipPath>
              </defs>
            </svg>
            <p class="xl:w-80 text-base leading-normal text-center mt-4">
              NetList is one of the best apps I've ever used and has saved me so much time.
              Now, using NetList's group functionality, I can enlist my friends to help me track down every physical copy of <em>Morbius</em>
              in existence–no matter where they are!
            </p>
          </div>
          <div
            class="
              text-white
              group-hover:text-indigo-700
              absolute
              bottom-0
              -mb-6
            "
          >
            <svg
              width="34"
              height="28"
              viewBox="0 0 34 28"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <g filter="url(#filter0_dd)">
                <path
                  d="M17 19L28.2583 3.25H5.74167L17 19Z"
                  fill="currentColor"
                />
              </g>
              <defs>
                <filter
                  id="filter0_dd"
                  x="0.741699"
                  y="0.25"
                  width="32.5167"
                  height="27.75"
                  filterUnits="userSpaceOnUse"
                  color-interpolation-filters="sRGB"
                >
                  <feFlood flood-opacity="0" result="BackgroundImageFix" />
                  <feColorMatrix
                    in="SourceAlpha"
                    type="matrix"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0"
                  />
                  <feMorphology
                    radius="1"
                    operator="erode"
                    in="SourceAlpha"
                    result="effect1_dropShadow"
                  />
                  <feOffset dy="4" />
                  <feGaussianBlur stdDeviation="3" />
                  <feColorMatrix
                    type="matrix"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.1 0"
                  />
                  <feBlend
                    mode="normal"
                    in2="BackgroundImageFix"
                    result="effect1_dropShadow"
                  />
                  <feColorMatrix
                    in="SourceAlpha"
                    type="matrix"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0"
                  />
                  <feOffset dy="2" />
                  <feGaussianBlur stdDeviation="2.5" />
                  <feColorMatrix
                    type="matrix"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.06 0"
                  />
                  <feBlend
                    mode="normal"
                    in2="effect1_dropShadow"
                    result="effect2_dropShadow"
                  />
                  <feBlend
                    mode="normal"
                    in="SourceGraphic"
                    in2="effect2_dropShadow"
                    result="shape"
                  />
                </filter>
              </defs>
            </svg>
          </div>
        </div>
        <div class="flex flex-col items-center justify-center mt-10">
          <img
            src="https://ca.slack-edge.com/T0GNFLF6D-U02D6Q9D4TZ-7d43cc250f37-512"
            alt="profile pictre"
            class="w-12 h-12 rounded-full overflow-hidden shadow"
          />
          <p class="text-base font-semibold leading-4 my-2 text-gray-800">
            Christopher Guarnera 
          </p>
          <p class="text-base leading-4 text-center text-gray-600">Film Enthusiast</p>
        </div>
      </div>
            
    </div>
  </body>
</template>

<script>
export default {
  name: "front-2-component",
  data() {
    return {};
  },
};
</script>

<style scoped></style>
